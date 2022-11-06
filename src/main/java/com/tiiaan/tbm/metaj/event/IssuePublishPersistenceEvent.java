package com.tiiaan.tbm.metaj.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class IssuePublishPersistenceEvent extends ApplicationEvent {

    private Long instanceId;
    private Long time;

    public Long getInstanceId() {
        return instanceId;
    }

    public Long getTime() {
        return time;
    }

    public IssuePublishPersistenceEvent(Object source, Long instanceId, Long time) {
        super(source);
        this.instanceId = instanceId;
        this.time = time;
    }

    public IssuePublishPersistenceEvent(Object source, Clock clock, Long instanceId, Long time) {
        super(source, clock);
        this.instanceId = instanceId;
        this.time = time;
    }

}
