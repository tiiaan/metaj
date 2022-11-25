package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.IssueComment;
import com.tiiaan.tbm.metaj.entity.IssueCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IssueCommentMapper {
    long countByExample(IssueCommentExample example);

    int deleteByExample(IssueCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IssueComment record);

    int insertSelective(IssueComment record);

    List<IssueComment> selectByExample(IssueCommentExample example);

    IssueComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IssueComment record, @Param("example") IssueCommentExample example);

    int updateByExample(@Param("record") IssueComment record, @Param("example") IssueCommentExample example);

    int updateByPrimaryKeySelective(IssueComment record);

    int updateByPrimaryKey(IssueComment record);
}