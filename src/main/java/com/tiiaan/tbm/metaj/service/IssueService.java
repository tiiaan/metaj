package com.tiiaan.tbm.metaj.service;

import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.Issue;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
public interface IssueService extends IService<Issue> {

    Result publishIssue(Issue issue);

    Result uploadFile(MultipartFile file);

    Result deleteFile(String filename);

    Result queryIssuesByInstanceId(Long instanceId, Integer curr, Integer closed, Boolean ofMe);

    Result closeIssue(Long id);

    //Result trackIssue(Long id);

}
