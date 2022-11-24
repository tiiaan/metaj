package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.InstanceEntity;
import com.tiiaan.tbm.metaj.entity.InstanceEntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InstanceMapper {
    long countByExample(InstanceEntityExample example);

    int deleteByExample(InstanceEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InstanceEntity record);

    int insertSelective(InstanceEntity record);

    List<InstanceEntity> selectByExample(InstanceEntityExample example);

    InstanceEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InstanceEntity record, @Param("example") InstanceEntityExample example);

    int updateByExample(@Param("record") InstanceEntity record, @Param("example") InstanceEntityExample example);

    int updateByPrimaryKeySelective(InstanceEntity record);

    int updateByPrimaryKey(InstanceEntity record);
}