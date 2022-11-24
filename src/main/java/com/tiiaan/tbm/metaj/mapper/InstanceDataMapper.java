package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.InstanceDataEntity;
import com.tiiaan.tbm.metaj.entity.InstanceDataEntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InstanceDataMapper {
    long countByExample(InstanceDataEntityExample example);

    int deleteByExample(InstanceDataEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InstanceDataEntity record);

    int insertSelective(InstanceDataEntity record);

    List<InstanceDataEntity> selectByExample(InstanceDataEntityExample example);

    InstanceDataEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InstanceDataEntity record, @Param("example") InstanceDataEntityExample example);

    int updateByExample(@Param("record") InstanceDataEntity record, @Param("example") InstanceDataEntityExample example);

    int updateByPrimaryKeySelective(InstanceDataEntity record);

    int updateByPrimaryKey(InstanceDataEntity record);
}