package com.tiiaan.tbm.metaj.controller;


import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.IssueProgressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/issue/progress")
public class IssueProgressController {

    @Resource
    IssueProgressService issueProgressService;

    @GetMapping("/query")
    public Result queryByIssueId(@RequestParam("issueId") Long issueId) {
        return issueProgressService.queryByIssueId(issueId);
    }

}
