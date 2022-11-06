package com.tiiaan.tbm.metaj.event.listener;

import com.tiiaan.tbm.metaj.event.IssuePublishPersistenceEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */


@Component
@Slf4j
public class IssuePublishPersistenceEventListener {


    @Async
    @EventListener(IssuePublishPersistenceEvent.class)
    public void persistence(IssuePublishPersistenceEvent event) {
        Long time = event.getTime();
        Long instanceId = event.getInstanceId();
        log.info("async event persistence instance=[{}] time=[{}]", instanceId, time);
    }


}
