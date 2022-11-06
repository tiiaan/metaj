package com.tiiaan.tbm.metaj.event.listener;

import com.tiiaan.tbm.metaj.event.IssuePublishFeedEvent;
import com.tiiaan.tbm.metaj.event.IssuePublishInstanceEvent;
import com.tiiaan.tbm.metaj.event.IssuePublishPersistenceEvent;
import com.tiiaan.tbm.metaj.exception.ErrorEnum;
import com.tiiaan.tbm.metaj.service.InstanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
        boolean updated = instanceService.update().setSql("issues = issues + 1").setSql("unsolved_issues = unsolved_issues + 1").eq("id", instanceId).update();
        ErrorEnum.DB_UPDATE_FAIL.assertIsTrue(updated);
        String key = CACHE_INSTANCE_KEY + instanceId;
        stringRedisTemplate.delete(key);
        log.info("event update tb_instance instanceId=[{}]", instanceId);
    }

    @Async
    @EventListener(IssuePublishFeedEvent.class)
    public void feed(IssuePublishFeedEvent event) {
        Long issueId = event.getIssueId();
        log.info("async event feed issue=[{}]", issueId);
    }

    @Async
    @EventListener(IssuePublishPersistenceEvent.class)
    public void persistence(IssuePublishPersistenceEvent event) {
        Long time = event.getTime();
        Long instanceId = event.getInstanceId();
        log.info("async event persistence instance=[{}] time=[{}]", instanceId, time);
    }

}
