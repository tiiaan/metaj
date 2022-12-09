package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.dto.ScrollResult;
import com.tiiaan.tbm.metaj.dto.TryAcquireResultDTO;
import com.tiiaan.tbm.metaj.entity.Issue;
import com.tiiaan.tbm.metaj.event.IssueClosedEvent;
import com.tiiaan.tbm.metaj.event.IssuePublishEvent;
import com.tiiaan.tbm.metaj.event.IssueSolvedEvent;
import com.tiiaan.tbm.metaj.exception.ErrorEnum;
import com.tiiaan.tbm.metaj.holder.UserHolder;
import com.tiiaan.tbm.metaj.mapper.IssueMapper;
import com.tiiaan.tbm.metaj.service.InstanceService;
import com.tiiaan.tbm.metaj.service.IssueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiiaan.tbm.metaj.util.SnowflakeId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.tiiaan.tbm.metaj.common.RedisConstants.*;
import static com.tiiaan.tbm.metaj.common.SysConstants.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */


@Slf4j
@Service
public class IssueServiceImpl extends ServiceImpl<IssueMapper, Issue> implements IssueService {


    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;
    @Resource
    private InstanceService instanceService;
    @Resource
    private IssueMapper issueMapper;
    @Resource
    private SnowflakeId snowflakeId;


    /**
     * 尝试获取发布资格
     * @param instanceId
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    @Override
    public Result tryAcquire(Long instanceId) {
        String issueId;
        Long userId = UserHolder.getUser().getId();

        //校验是否有5分钟内发布的报告，有的话直接跳转过去
        //String loKey = LO_PUBLISH_LOCK_KEY + instanceId;
        //issueId = stringRedisTemplate.opsForValue().get(loKey);
        //if (issueId != null && issueId.length() != 0) {
        //    return Result.ok(new TryAcquireResultDTO(2, Long.valueOf(issueId)));
        //}

        //校验是否有30分钟内发布的报告，有的话弹出对话框询问一下
        //String hiKey = HI_PUBLISH_LOCK_KEY + instanceId;
        //issueId = stringRedisTemplate.opsForValue().get(hiKey);
        //if (issueId != null && issueId.length() != 0) {
        //    log.info("user[{}] find published issue in 30 min, issueId=[{}]", userId, issueId);
        //    return Result.ok(new TryAcquireResultDTO(2, issueId));
        //}
        //log.info("user[{}] find no published issue in 30 min", userId);

        //没有符合条件的已发布报告，则尝试获取锁，获取到了就可以发布，获取不到可以先填写补充信息
        String tryLockKey = TRY_PUBLISH_LOCK_KEY + instanceId;
        issueId = snowflakeId.nextId().toString();
        Boolean getLock = stringRedisTemplate.opsForValue().setIfAbsent(tryLockKey, issueId, TRY_PUBLISH_LOCK_TTL, TTL_UNIT);
        if (Boolean.FALSE.equals(getLock)) {
            issueId = stringRedisTemplate.opsForValue().get(tryLockKey);
            if (issueId != null && issueId.length() != 0) {
                log.info("user[{}] acquire lock fail, issueId=[{}]", userId, issueId);
                return Result.ok(new TryAcquireResultDTO(0, issueId));
            }
        }

        //获取到了就可以发布
        log.info("user[{}] acquire lock success, issueId=[{}] <<<<<<<<<<<<<<<<<<<<<<<", userId, issueId);
        return Result.ok(new TryAcquireResultDTO(1, issueId));

    }



    @Transactional
    @Override
    public Result publishIssue(Issue issue) {
        //获取用户
        Long userId = UserHolder.getUser().getId();
        issue.setUserId(userId);

        //token校验幂等
        Long issueId = issue.getId();
        ErrorEnum.DO_NOT_SUBMIT_FOR_MANY_TIMES.assertIsFalse(isSubmitted(issue));

        //保存报告
        boolean saved = this.save(issue);
        ErrorEnum.DB_UPDATE_FAIL.assertIsTrue(saved);

        //推送事件
        applicationEventPublisher.publishEvent(new IssuePublishEvent(this, issue));

        log.info("[{}]publish success issue=[{}]", Thread.currentThread().getName(), issueId);
        return Result.ok(issueId);
    }


    private boolean isSubmitted(Issue issue) {
        Long instanceId = issue.getInstanceId();
        Long issueId = issue.getId();
        String tryLockKey = TRY_PUBLISH_LOCK_KEY + instanceId;
        String check = stringRedisTemplate.opsForValue().get(tryLockKey);
        return check == null || check.length() == 0 || !check.equals(issueId.toString());
    }


    /**
     * 取消发布
     * @param instanceId
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    @Override
    public Result abortPublish(Long instanceId) {

        //释放持有的发布锁
        String tryLockKey = TRY_PUBLISH_LOCK_KEY + instanceId;
        stringRedisTemplate.delete(tryLockKey);


        return null;

    }


    @Override
    public Result uploadFile(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String filename = getNewFilename(originalFilename);
            file.transferTo(new File(IMAGE_UPLOAD_DIR, filename));
            return Result.ok(filename);
        } catch (IOException e) {
            ErrorEnum.UPLOAD_ERROR.assertFail();
        }
        return null;
    }



    @Override
    public Result deleteFile(String filename) {
        File file = new File(IMAGE_UPLOAD_DIR, filename);
        ErrorEnum.INVALID_FILENAME.assertIsFalse(file.isDirectory());
        FileUtil.del(file);
        return Result.ok();
    }



    @Override
    public Result queryIssuesByInstanceId(Long instanceId, Integer curr, Integer closed, Boolean ofMe) {
        Long userId = UserHolder.getUser().getId();
        userId = ofMe ? userId : -1;
        Integer start = (curr - 1) * ISSUE_PAGE_SIZE;
        List<Issue> issues = issueMapper.queryIssuesByInstanceIdDynamic(
                start,
                ISSUE_PAGE_SIZE,
                instanceId,
                closed,
                userId);
        return Result.ok(issues);
    }


    @Transactional
    @Override
    public Result closeIssue(Long id) {
        log.info("close issue=[{}]", id);
        Long userId = UserHolder.getUser().getId();
        Issue issue = this.getById(id);
        ErrorEnum.DB_QUERY_FAIL.assertNotNull(issue);
        ErrorEnum.ONLY_CLOSED_BY_OWNER.assertIsTrue(Objects.equals(issue.getUserId(), userId));
        this.update().setSql("closed = 1").eq("id", id).update();
        applicationEventPublisher.publishEvent(new IssueClosedEvent(this, issue));
        return Result.ok();
    }



    @Transactional
    @Override
    public Result solveIssue(Long id) {
        log.info("solve issue=[{}]", id);
        Long userId = UserHolder.getUser().getId();
        Issue issue = this.getById(id);
        ErrorEnum.DB_QUERY_FAIL.assertNotNull(issue);
        ErrorEnum.ONLY_CLOSED_BY_OWNER.assertIsTrue(Objects.equals(issue.getUserId(), userId));
        this.update().setSql("solved = 1").eq("id", id).update();
        applicationEventPublisher.publishEvent(new IssueSolvedEvent(this, issue));
        return Result.ok();
    }


    @Override
    public Result queryIssueById(Long id) {
        return Result.ok(getById(id));
    }


    /**
     * 查询feed收件箱中的报告
     * @param lastId
     * @param offset
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    //@Override
    //public Result queryIssuesOfWatching(Long lastId, Integer offset) {
    //    Long userId = UserHolder.getUser().getId();
    //    String feedKey = FEED_KEY + userId;
    //    Set<ZSetOperations.TypedTuple<String>> typedTuples = stringRedisTemplate.opsForZSet()
    //            .reverseRangeByScoreWithScores(feedKey, 0, lastId, offset, FEED_PAGE_SIZE);
    //    if (typedTuples == null || typedTuples.isEmpty()) {
    //        return Result.ok();
    //    }
    //    ArrayList<Long> ids = new ArrayList<>(typedTuples.size());
    //    long minTime = 0;
    //    int os = 1;
    //    for (ZSetOperations.TypedTuple<String> tuple : typedTuples) {
    //        ids.add(Long.valueOf(tuple.getValue()));
    //        long time = tuple.getScore().longValue();
    //        if (time == minTime) {
    //            os++;
    //        } else {
    //            minTime = time;
    //            os = 1;
    //        }
    //    }
    //    String join = StrUtil.join(",", ids);
    //    List<Issue> issues = this.query().in("id", ids).last("ORDER BY FIELD(id," + join + ")").list();
    //    ScrollResult scrollResult = new ScrollResult();
    //    scrollResult.setList(issues);
    //    scrollResult.setOffset(os);
    //    scrollResult.setMinTime(minTime);
    //    return Result.ok(scrollResult);
    //}

    @Override
    public Result queryIssuesOfWatching(Integer curr) {
        Long userId = UserHolder.getUser().getId();
        String feedKey = FEED_KEY + userId;
        Long start = (long) (curr - 1) * FEED_PAGE_SIZE;
        Set<String> ids = stringRedisTemplate.opsForZSet().reverseRange(feedKey, start, start + FEED_PAGE_SIZE - 1);

        //Set<ZSetOperations.TypedTuple<String>> typedTuples = stringRedisTemplate.opsForZSet()
        //        .reverseRangeByScoreWithScores(feedKey, 0, lastId, offset, FEED_PAGE_SIZE);
        //if (typedTuples == null || typedTuples.isEmpty()) {
        //    return Result.ok();
        //}
        //ArrayList<Long> ids = new ArrayList<>(typedTuples.size());
        //long minTime = 0;
        //int os = 1;
        //for (ZSetOperations.TypedTuple<String> tuple : typedTuples) {
        //    ids.add(Long.valueOf(tuple.getValue()));
        //    long time = tuple.getScore().longValue();
        //    if (time == minTime) {
        //        os++;
        //    } else {
        //        minTime = time;
        //        os = 1;
        //    }
        //}
        String join = StrUtil.join(",", ids);
        List<Issue> issues = this.query().in("id", ids).last("ORDER BY FIELD(id," + join + ")").list();
        //ScrollResult scrollResult = new ScrollResult();
        //scrollResult.setList(issues);
        //scrollResult.setOffset(os);
        //scrollResult.setMinTime(minTime);
        return Result.ok(issues);
    }


    @Override
    public Result queryIssuesCountOfWatching() {
        Long userId = UserHolder.getUser().getId();
        String feedKey = FEED_KEY + userId;
        Long size = stringRedisTemplate.opsForZSet().size(feedKey);
        return Result.ok(size);
    }


    //@Override
    //public Result trackIssue(Long id) {
    //    Long userId = UserHolder.getUser().getId();
    //    String userKey = USER_TRACKING_KEY + userId;
    //    String issueKey = ISSUE_TRACKING_KEY + id;
    //    Boolean tracked = stringRedisTemplate.opsForSet().isMember(userKey, id.toString());
    //    if (Boolean.FALSE.equals(tracked)) {
    //        stringRedisTemplate.opsForValue()
    //        stringRedisTemplate.opsForSet().add(userKey, id.toString());
    //    }
    //}



    //public Result watchInstance(Long id) {
    //    //获取用户
    //    Long userId = UserHolder.getUser().getId();
    //    String userKey = USER_WATCHING_KEY + userId;
    //    String instKey = INSTANCE_WATCHING_KEY + id;
    //    //判断用户是否已经关注过了
    //    Boolean watched = stringRedisTemplate.opsForSet().isMember(userKey, id.toString());
    //    if (Boolean.FALSE.equals(watched)) {
    //        //watchService.save(new Watch(userId, id));
    //        //update().setSql("watching = watching + 1").eq("id", id).update();
    //        //stringRedisTemplate.opsForZSet().add(instKey, userId.toString(), System.currentTimeMillis());
    //        stringRedisTemplate.opsForValue().increment(instKey);
    //        stringRedisTemplate.opsForSet().add(userKey, id.toString());
    //        log.info("user [{}] watch instance [{}]", userId, id);
    //    } else {
    //        //watchService.remove(new QueryWrapper<Watch>().eq("user_id", userId).eq("instance_id", id));
    //        //update().setSql("watching = watching - 1").eq("id", id).update();
    //        //stringRedisTemplate.opsForZSet().remove(instKey, userId.toString());
    //        stringRedisTemplate.opsForSet().remove(userKey, id.toString());
    //        stringRedisTemplate.opsForValue().decrement(instKey);
    //        log.info("user [{}] unwatch instance [{}]", userId, id);
    //    }
    //    return Result.ok();
    //}



    private String getNewFilename(String originalFilename) {
        // 获取后缀
        String suffix = StrUtil.subAfter(originalFilename, ".", true);
        // 生成目录
        String name = UUID.randomUUID().toString(true);
        int hash = name.hashCode();
        int d1 = hash & 0xF;
        int d2 = (hash >> 4) & 0xF;
        // 判断目录是否存在
        File dir = new File(IMAGE_UPLOAD_DIR, StrUtil.format("/issues/{}/{}", d1, d2));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 生成文件名
        return StrUtil.format("/issues/{}/{}/{}.{}", d1, d2, name, suffix);
    }


}
