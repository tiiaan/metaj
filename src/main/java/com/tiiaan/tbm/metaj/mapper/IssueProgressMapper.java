package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.IssueProgress;
import com.tiiaan.tbm.metaj.entity.IssueProgressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IssueProgressMapper {
    long countByExample(IssueProgressExample example);

    int deleteByExample(IssueProgressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IssueProgress record);

    int insertSelective(IssueProgress record);

    List<IssueProgress> selectByExample(IssueProgressExample example);

    IssueProgress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IssueProgress record, @Param("example") IssueProgressExample example);

    int updateByExample(@Param("record") IssueProgress record, @Param("example") IssueProgressExample example);

    int updateByPrimaryKeySelective(IssueProgress record);

    int updateByPrimaryKey(IssueProgress record);
}