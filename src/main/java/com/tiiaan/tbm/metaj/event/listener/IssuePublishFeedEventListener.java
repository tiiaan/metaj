package com.tiiaan.tbm.metaj.event.listener;

import com.tiiaan.tbm.metaj.event.IssuePublishFeedEvent;
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
public class IssuePublishFeedEventListener {

    @Async
    @EventListener(IssuePublishFeedEvent.class)
    public void feed(IssuePublishFeedEvent event) {
        Long issueId = event.getIssueId();
        log.info("async event feed issue=[{}]", issueId);
    }

}
