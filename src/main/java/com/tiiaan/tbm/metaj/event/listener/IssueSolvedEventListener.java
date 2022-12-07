package com.tiiaan.tbm.metaj.event.listener;

import com.tiiaan.tbm.metaj.common.ProgressEnum;
import com.tiiaan.tbm.metaj.entity.IssueProgress;
import com.tiiaan.tbm.metaj.event.IssueClosedEvent;
import com.tiiaan.tbm.metaj.event.IssuePublishEvent;
import com.tiiaan.tbm.metaj.event.IssueSolvedEvent;
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
public class IssueSolvedEventListener {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private InstanceService instanceService;
    @Resource
    private IssueProgressService issueProgressService;


    @EventListener(IssueSolvedEvent.class)
    public void updateInstance(IssueSolvedEvent event) {
        Long instanceId= event.getIssue().getInstanceId();
        instanceService.update().setSql("health = if(unsolved_issues = 1, 1, 3)").setSql("unsolved_issues = unsolved_issues - 1").eq("id", instanceId).update();
        String key = CACHE_INSTANCE_KEY + instanceId;
        stringRedisTemplate.delete(key);
        log.info("[{}]event update tb_instance instanceId=[{}]", Thread.currentThread().getName(), instanceId);
    }


    @EventListener(IssueSolvedEvent.class)
    public void updateProgress(IssueSolvedEvent event) {
        Long issueId = event.getIssue().getId();
        Long userId = event.getIssue().getUserId();
        IssueProgress issueProgress = new IssueProgress();
        issueProgress.setIssueId(issueId);
        issueProgress.setUserId(userId);
        issueProgress.setContent(ProgressEnum.SOLVED.getContent());
        issueProgressService.save(issueProgress);
        log.info("[{}]event update tb_issue_progress", Thread.currentThread().getName());
    }


}
