package com.tiiaan.tbm.metaj.service.impl;

import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.Issue;
import com.tiiaan.tbm.metaj.service.IssueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class IssueServiceImplTest {

    @Resource
    private IssueService issueService;

    @Test
    public void publishIssue() {
        Issue issue = new Issue();
        issue.setId(1000L);
        issue.setUserId(1L);
        issue.setInstanceId(10L);
        issue.setTime(System.currentTimeMillis());
        Result result = issueService.publishIssue(issue);
        System.out.println(result.getData());

    }

}