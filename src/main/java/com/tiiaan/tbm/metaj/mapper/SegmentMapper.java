package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.SegmentEntity;
import com.tiiaan.tbm.metaj.entity.SegmentEntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SegmentMapper {
    long countByExample(SegmentEntityExample example);

    int deleteByExample(SegmentEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SegmentEntity record);

    int insertSelective(SegmentEntity record);

    List<SegmentEntity> selectByExample(SegmentEntityExample example);

    SegmentEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SegmentEntity record, @Param("example") SegmentEntityExample example);

    int updateByExample(@Param("record") SegmentEntity record, @Param("example") SegmentEntityExample example);

    int updateByPrimaryKeySelective(SegmentEntity record);

    int updateByPrimaryKey(SegmentEntity record);
}