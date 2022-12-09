package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.Issue;
import com.tiiaan.tbm.metaj.entity.IssueComment;
import com.tiiaan.tbm.metaj.exception.ErrorEnum;
import com.tiiaan.tbm.metaj.holder.UserHolder;
import com.tiiaan.tbm.metaj.mapper.IssueCommentMapper;
import com.tiiaan.tbm.metaj.service.IssueCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
@Service
public class IssueCommentServiceImpl extends ServiceImpl<IssueCommentMapper, IssueComment> implements IssueCommentService {


    @Override
    public Result add(Issue issue) {
        Long userId = UserHolder.getUser().getId();
        IssueComment issueComment = new IssueComment();
        issueComment.setUserId(userId);
        issueComment.setIssueId(issue.getId());
        issueComment.setContent(issue.getDescription());
        issueComment.setFile(issue.getImages());
        boolean saved = this.save(issueComment);
        ErrorEnum.DB_UPDATE_FAIL.assertIsTrue(saved);
        return Result.ok(issueComment.getId());
    }

}
