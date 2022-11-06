package com.tiiaan.tbm.metaj.controller;


import com.tiiaan.tbm.metaj.dto.IssueFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.Issue;
import com.tiiaan.tbm.metaj.service.IssueService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/issue")
public class IssueController {

    @Resource
    private IssueService issueService;

    @PostMapping("/publish")
    public Result publishIssue(@RequestBody Issue issue) {
        return issueService.publishIssue(issue);
    }


    @PostMapping("/file/upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        return issueService.uploadFile(file);
    }


    @GetMapping("/file/delete")
    public Result deleteFile(@RequestParam("filename") String filename) {
        return issueService.deleteFile(filename);
    }

}
