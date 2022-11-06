package com.tiiaan.tbm.metaj.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class IssuePublishFeedEvent extends ApplicationEvent {

    private Long issueId;

    public Long getIssueId() {
        return issueId;
    }

    public IssuePublishFeedEvent(Object source, Long issueId) {
        super(source);
        this.issueId = issueId;
    }

    public IssuePublishFeedEvent(Object source, Clock clock, Long issueId) {
        super(source, clock);
        this.issueId = issueId;
    }

}
