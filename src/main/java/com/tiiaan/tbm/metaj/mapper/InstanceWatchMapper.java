package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.InstanceWatchEntity;
import com.tiiaan.tbm.metaj.entity.InstanceWatchEntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InstanceWatchMapper {
    long countByExample(InstanceWatchEntityExample example);

    int deleteByExample(InstanceWatchEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InstanceWatchEntity record);

    int insertSelective(InstanceWatchEntity record);

    List<InstanceWatchEntity> selectByExample(InstanceWatchEntityExample example);

    InstanceWatchEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InstanceWatchEntity record, @Param("example") InstanceWatchEntityExample example);

    int updateByExample(@Param("record") InstanceWatchEntity record, @Param("example") InstanceWatchEntityExample example);

    int updateByPrimaryKeySelective(InstanceWatchEntity record);

    int updateByPrimaryKey(InstanceWatchEntity record);
}