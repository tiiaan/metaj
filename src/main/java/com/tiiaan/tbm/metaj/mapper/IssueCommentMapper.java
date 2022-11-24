package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.IssueCommentEntity;
import com.tiiaan.tbm.metaj.entity.IssueCommentEntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IssueCommentMapper {
    long countByExample(IssueCommentEntityExample example);

    int deleteByExample(IssueCommentEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IssueCommentEntity record);

    int insertSelective(IssueCommentEntity record);

    List<IssueCommentEntity> selectByExample(IssueCommentEntityExample example);

    IssueCommentEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IssueCommentEntity record, @Param("example") IssueCommentEntityExample example);

    int updateByExample(@Param("record") IssueCommentEntity record, @Param("example") IssueCommentEntityExample example);

    int updateByPrimaryKeySelective(IssueCommentEntity record);

    int updateByPrimaryKey(IssueCommentEntity record);
}