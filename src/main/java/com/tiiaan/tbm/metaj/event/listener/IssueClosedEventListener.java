package com.tiiaan.tbm.metaj.event.listener;

import com.tiiaan.tbm.metaj.common.ProgressEnum;
import com.tiiaan.tbm.metaj.entity.IssueProgress;
import com.tiiaan.tbm.metaj.event.IssueClosedEvent;
import com.tiiaan.tbm.metaj.event.IssuePublishEvent;
import com.tiiaan.tbm.metaj.service.InstanceService;
import com.tiiaan.tbm.metaj.service.IssueProgressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.tiiaan.tbm.metaj.common.RedisConstants.CACHE_INSTANCE_KEY;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */


@Slf4j
@Component
public class IssueClosedEventListener {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private InstanceService instanceService;
    @Resource
    private IssueProgressService issueProgressService;


    @EventListener(IssueClosedEvent.class)
    public void updateInstance(IssueClosedEvent event) {
        Long instanceId= event.getIssue().getInstanceId();
        instanceService.update().setSql("unclosed_issues = unclosed_issues - 1").eq("id", instanceId).update();
        String key = CACHE_INSTANCE_KEY + instanceId;
        stringRedisTemplate.delete(key);
        log.info("[{}]event update tb_instance instanceId=[{}]", Thread.currentThread().getName(), instanceId);
    }


    @EventListener(IssueClosedEvent.class)
    public void updateProgress(IssueClosedEvent event) {
        Long issueId = event.getIssue().getId();
        Long userId = event.getIssue().getUserId();
        IssueProgress issueProgress = new IssueProgress();
        issueProgress.setIssueId(issueId);
        issueProgress.setUserId(userId);
        issueProgress.setContent(ProgressEnum.CLOSED.getContent());
        issueProgressService.save(issueProgress);
        log.info("[{}]event update tb_issue_progress", Thread.currentThread().getName());
    }


}
