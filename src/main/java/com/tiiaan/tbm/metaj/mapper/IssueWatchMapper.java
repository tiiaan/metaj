package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.IssueWatchEntity;
import com.tiiaan.tbm.metaj.entity.IssueWatchEntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IssueWatchMapper {
    long countByExample(IssueWatchEntityExample example);

    int deleteByExample(IssueWatchEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IssueWatchEntity record);

    int insertSelective(IssueWatchEntity record);

    List<IssueWatchEntity> selectByExample(IssueWatchEntityExample example);

    IssueWatchEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IssueWatchEntity record, @Param("example") IssueWatchEntityExample example);

    int updateByExample(@Param("record") IssueWatchEntity record, @Param("example") IssueWatchEntityExample example);

    int updateByPrimaryKeySelective(IssueWatchEntity record);

    int updateByPrimaryKey(IssueWatchEntity record);
}