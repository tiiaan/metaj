package com.tiiaan.tbm.metaj.controller;


import com.tiiaan.tbm.metaj.dto.IssueFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.Issue;
import com.tiiaan.tbm.metaj.service.IssueService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Resource
    private IssueService issueService;

    @PostMapping("/publish")
    public Result publishIssue(@Valid @RequestBody Issue issue) {
        return issueService.publishIssue(issue);
    }

    @PutMapping("/close/{id}")
    public Result closeIssue(@PathVariable("id") Long id) {
        return issueService.closeIssue(id);
    }

    @PutMapping("/solve/{id}")
    public Result solveIssue(@PathVariable("id") Long id) {
        return issueService.solveIssue(id);
    }


    @PostMapping("/file/upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        return issueService.uploadFile(file);
    }


    @GetMapping("/file/delete")
    public Result deleteFile(@RequestParam("filename") String filename) {
        return issueService.deleteFile(filename);
    }


    @GetMapping("/query")
    public Result queryIssuesByInstanceId(@RequestParam(value = "instanceId") Long instanceId,
                                          @RequestParam(value = "curr", defaultValue = "1") Integer curr,
                                          @RequestParam(value = "closed", defaultValue = "-1") Integer closed,
                                          @RequestParam(value = "ofMe", defaultValue = "false") Boolean ofMe) {
        return issueService.queryIssuesByInstanceId(instanceId, curr, closed, ofMe);
    }




    //@PutMapping("/track/{id}")
    //public Result trackIssue(@PathVariable("id") Long id) {
    //    return issueService.trackIssue(id);
    //}


}
