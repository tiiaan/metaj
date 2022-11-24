package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.IssueProgressEntity;
import com.tiiaan.tbm.metaj.entity.IssueProgressEntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IssueProgressMapper {
    long countByExample(IssueProgressEntityExample example);

    int deleteByExample(IssueProgressEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IssueProgressEntity record);

    int insertSelective(IssueProgressEntity record);

    List<IssueProgressEntity> selectByExample(IssueProgressEntityExample example);

    IssueProgressEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IssueProgressEntity record, @Param("example") IssueProgressEntityExample example);

    int updateByExample(@Param("record") IssueProgressEntity record, @Param("example") IssueProgressEntityExample example);

    int updateByPrimaryKeySelective(IssueProgressEntity record);

    int updateByPrimaryKey(IssueProgressEntity record);
}