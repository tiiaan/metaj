package com.tiiaan.tbm.metaj.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class IssuePublishTrackEvent extends ApplicationEvent {

    private Long userId;
    private Long issueId;

    public Long getUserId() {
        return userId;
    }

    public Long getIssueId() {
        return issueId;
    }

    public IssuePublishTrackEvent(Object source, Long userId, Long issueId) {
        super(source);
        this.userId = userId;
        this.issueId = issueId;
    }

}
