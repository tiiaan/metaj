package com.tiiaan.tbm.metaj.service.impl;

import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.IssueProgress;
import com.tiiaan.tbm.metaj.mapper.IssueProgressMapper;
import com.tiiaan.tbm.metaj.service.IssueProgressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
@Service
public class IssueProgressServiceImpl extends ServiceImpl<IssueProgressMapper, IssueProgress> implements IssueProgressService {


    @Override
    public Result queryByIssueId(Long issueId) {
        List<IssueProgress> progresses = this.query().eq("issue_id", issueId).list();
        return Result.ok(progresses);
    }


}
