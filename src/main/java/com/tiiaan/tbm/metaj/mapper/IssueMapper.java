package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.IssueEntity;
import com.tiiaan.tbm.metaj.entity.IssueEntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IssueMapper {
    long countByExample(IssueEntityExample example);

    int deleteByExample(IssueEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IssueEntity record);

    int insertSelective(IssueEntity record);

    List<IssueEntity> selectByExample(IssueEntityExample example);

    IssueEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IssueEntity record, @Param("example") IssueEntityExample example);

    int updateByExample(@Param("record") IssueEntity record, @Param("example") IssueEntityExample example);

    int updateByPrimaryKeySelective(IssueEntity record);

    int updateByPrimaryKey(IssueEntity record);
}