package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.Issue;
import com.tiiaan.tbm.metaj.event.IssuePublishEvent;
import com.tiiaan.tbm.metaj.exception.ErrorEnum;
import com.tiiaan.tbm.metaj.holder.UserHolder;
import com.tiiaan.tbm.metaj.mapper.IssueMapper;
import com.tiiaan.tbm.metaj.service.InstanceService;
import com.tiiaan.tbm.metaj.service.IssueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

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


    @Transactional
    @Override
    public Result publishIssue(Issue issue) {
        //获取用户
        Long userId = UserHolder.getUser().getId();
        issue.setUserId(userId);

        //保存报告
        boolean saved = this.save(issue);
        ErrorEnum.DB_UPDATE_FAIL.assertIsTrue(saved);
        Long issueId = issue.getId();

        //推送事件
        applicationEventPublisher.publishEvent(new IssuePublishEvent(this, issue));

        log.info("[{}]publish success issue=[{}]", Thread.currentThread().getName(), issueId);
        return Result.ok(issueId);
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
        Long instanceId= issue.getInstanceId();
        instanceService.update().setSql("unclosed_issues = unclosed_issues - 1").eq("id", instanceId).update();
        String key = CACHE_INSTANCE_KEY + instanceId;
        stringRedisTemplate.delete(key);
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
        Long instanceId= issue.getInstanceId();
        instanceService.update().setSql("health = if(unsolved_issues = 1, 1, 3)").setSql("unsolved_issues = unsolved_issues - 1").eq("id", instanceId).update();
        String key = CACHE_INSTANCE_KEY + instanceId;
        stringRedisTemplate.delete(key);
        return Result.ok();
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
