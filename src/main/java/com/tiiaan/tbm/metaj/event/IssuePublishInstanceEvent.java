package com.tiiaan.tbm.metaj.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class IssuePublishInstanceEvent extends ApplicationEvent {

    private Long instanceId;

    public Long getInstanceId() {
        return instanceId;
    }

    public IssuePublishInstanceEvent(Object source, Long instanceId) {
        super(source);
        this.instanceId = instanceId;
    }

}
