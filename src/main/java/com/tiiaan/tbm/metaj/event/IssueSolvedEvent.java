package com.tiiaan.tbm.metaj.event;

import com.tiiaan.tbm.metaj.entity.Issue;
import org.springframework.context.ApplicationEvent;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class IssueSolvedEvent extends ApplicationEvent {

    private Issue issue;

    public Issue getIssue() {
        return issue;
    }

    public IssueSolvedEvent(Object source, Issue issue) {
        super(source);
        this.issue = issue;
    }
}
