package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.Issue;
import com.tiiaan.tbm.metaj.event.IssuePublishFeedEvent;
import com.tiiaan.tbm.metaj.event.IssuePublishInstanceEvent;
import com.tiiaan.tbm.metaj.event.IssuePublishPersistenceEvent;
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
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.Clock;
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


    @Override
    public Result publishIssue(Issue issue) {
        //获取用户
        Long userId = UserHolder.getUser().getId();
        issue.setUserId(userId);

        //保存报告
        this.save(issue);
        Long issueId = issue.getId();

        //同步修改tb_instance表
        applicationEventPublisher.publishEvent(new IssuePublishInstanceEvent(this, issue.getInstanceId()));

        //异步推送站内消息
        applicationEventPublisher.publishEvent(new IssuePublishFeedEvent(this, issueId));

        //异步持久化30分钟数据
        if (issue.getDataset() == 1) {
            applicationEventPublisher.publishEvent(new IssuePublishPersistenceEvent(this, issue.getInstanceId(), issue.getTime()));
        }

        log.info("publish success issue=[{}]", issueId);
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
