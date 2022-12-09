package com.tiiaan.tbm.metaj.service;

import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.Issue;
import com.tiiaan.tbm.metaj.entity.IssueComment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
public interface IssueCommentService extends IService<IssueComment> {

    Result add(Issue issue);

}
