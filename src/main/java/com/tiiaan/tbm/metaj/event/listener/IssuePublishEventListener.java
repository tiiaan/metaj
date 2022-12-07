package com.tiiaan.tbm.metaj.event.listener;

import com.tiiaan.tbm.metaj.common.ProgressEnum;
import com.tiiaan.tbm.metaj.entity.IssueProgress;
import com.tiiaan.tbm.metaj.event.IssuePublishEvent;
import com.tiiaan.tbm.metaj.exception.ErrorEnum;
import com.tiiaan.tbm.metaj.service.InstanceService;
import com.tiiaan.tbm.metaj.service.IssueProgressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.annotation.Resource;
import static com.tiiaan.tbm.metaj.common.RedisConstants.*;


/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Component
@Slf4j
public class IssuePublishEventListener {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private InstanceService instanceService;
    @Resource
    private IssueProgressService issueProgressService;


    @EventListener(IssuePublishEvent.class)
    public void updateInstance(IssuePublishEvent event) {
        Long instanceId = event.getIssue().getInstanceId();
        boolean updated = instanceService.update().setSql("health = 3").setSql("issues = issues + 1").setSql("unsolved_issues = unsolved_issues + 1").setSql("unclosed_issues = unclosed_issues + 1").eq("id", instanceId).update();
        ErrorEnum.DB_UPDATE_FAIL.assertIsTrue(updated);
        String key = CACHE_INSTANCE_KEY + instanceId;
        stringRedisTemplate.delete(key);
        log.info("[{}]event update tb_instance instanceId=[{}]", Thread.currentThread().getName(), instanceId);
    }


    @EventListener(IssuePublishEvent.class)
    public void updateProgress(IssuePublishEvent event) {
        Long issueId = event.getIssue().getId();
        Long userId = event.getIssue().getUserId();
        IssueProgress issueProgress = new IssueProgress();
        issueProgress.setIssueId(issueId);
        issueProgress.setUserId(userId);
        issueProgress.setContent(ProgressEnum.PUBLISH.getContent());
        issueProgressService.save(issueProgress);
        log.info("[{}]event update tb_issue_progress", Thread.currentThread().getName());
    }


    @Async("issueTaskExecutor")
    @TransactionalEventListener(classes = IssuePublishEvent.class, phase = TransactionPhase.AFTER_COMMIT)
    public void feed(IssuePublishEvent event) {
        Long issueId = event.getIssue().getId();
        log.info("[{}]async event feed issue=[{}]", Thread.currentThread().getName(), issueId);
    }


    @Async("issueTaskExecutor")
    @TransactionalEventListener(classes = IssuePublishEvent.class, phase = TransactionPhase.AFTER_COMMIT)
    public void persistence(IssuePublishEvent event) {
        if (event.getIssue().getDataset() == 1) {
            Long time = event.getIssue().getTime();
            Long instanceId = event.getIssue().getInstanceId();
            log.info("[{}]async event persistence instance=[{}] time=[{}]", Thread.currentThread().getName(), instanceId, time);
        }
    }

}
