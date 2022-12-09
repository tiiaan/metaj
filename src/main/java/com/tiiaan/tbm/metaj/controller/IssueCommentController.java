package com.tiiaan.tbm.metaj.controller;


import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.Issue;
import com.tiiaan.tbm.metaj.service.IssueCommentService;
import com.tiiaan.tbm.metaj.service.IssueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
@RestController
@RequestMapping("/issue/comment")
public class IssueCommentController {

    @Resource
    private IssueCommentService issueCommentService;

    @PostMapping("/add")
    public Result add(@RequestBody Issue issue) {
        return issueCommentService.add(issue);
    }

}
