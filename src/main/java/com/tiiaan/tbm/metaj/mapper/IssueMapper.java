package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.Issue;
import com.tiiaan.tbm.metaj.entity.IssueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IssueMapper {
    long countByExample(IssueExample example);

    int deleteByExample(IssueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Issue record);

    int insertSelective(Issue record);

    List<Issue> selectByExample(IssueExample example);

    Issue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByExample(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);
}