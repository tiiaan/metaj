package com.tiiaan.tbm.metaj.event.listener;

import com.tiiaan.tbm.metaj.event.IssuePublishFeedEvent;
import com.tiiaan.tbm.metaj.event.IssuePublishInstanceEvent;
import com.tiiaan.tbm.metaj.event.IssuePublishPersistenceEvent;
import com.tiiaan.tbm.metaj.event.IssuePublishTrackEvent;
import com.tiiaan.tbm.metaj.exception.ErrorEnum;
import com.tiiaan.tbm.metaj.service.InstanceService;
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


    @EventListener(IssuePublishInstanceEvent.class)
    public void updateInstance(IssuePublishInstanceEvent event) {
        Long instanceId = event.getInstanceId();
        boolean updated = instanceService.update().setSql("health = 3").setSql("issues = issues + 1").setSql("unsolved_issues = unsolved_issues + 1").eq("id", instanceId).update();
        ErrorEnum.DB_UPDATE_FAIL.assertIsTrue(updated);
        String key = CACHE_INSTANCE_KEY + instanceId;
        stringRedisTemplate.delete(key);
        log.info("[{}]event update tb_instance instanceId=[{}]", Thread.currentThread().getName(), instanceId);
    }



    @Async("issueTaskExecutor")
    @TransactionalEventListener(classes = IssuePublishTrackEvent.class, phase = TransactionPhase.AFTER_COMMIT)
    public void track(IssuePublishTrackEvent event) {
        Long userId = event.getUserId();
        Long issueId = event.getIssueId();
        String userKey = USER_TRACKING_KEY + userId;
        stringRedisTemplate.opsForSet().add(userKey, issueId.toString());
    }


    @Async("issueTaskExecutor")
    //@EventListener(IssuePublishFeedEvent.class)
    @TransactionalEventListener(classes = IssuePublishFeedEvent.class, phase = TransactionPhase.AFTER_COMMIT)
    public void feed(IssuePublishFeedEvent event) {
        Long issueId = event.getIssueId();
        log.info("[{}]async event feed issue=[{}]", Thread.currentThread().getName(), issueId);
    }


    @Async("issueTaskExecutor")
    //@EventListener(IssuePublishPersistenceEvent.class)
    @TransactionalEventListener(classes = IssuePublishPersistenceEvent.class, phase = TransactionPhase.AFTER_COMMIT)
    public void persistence(IssuePublishPersistenceEvent event) {
        Long time = event.getTime();
        Long instanceId = event.getInstanceId();
        log.info("[{}]async event persistence instance=[{}] time=[{}]", Thread.currentThread().getName(), instanceId, time);
    }

}
