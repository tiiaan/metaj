package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.Segment;
import com.tiiaan.tbm.metaj.entity.SegmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SegmentMapper {
    long countByExample(SegmentExample example);

    int deleteByExample(SegmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Segment record);

    int insertSelective(Segment record);

    List<Segment> selectByExample(SegmentExample example);

    Segment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Segment record, @Param("example") SegmentExample example);

    int updateByExample(@Param("record") Segment record, @Param("example") SegmentExample example);

    int updateByPrimaryKeySelective(Segment record);

    int updateByPrimaryKey(Segment record);
}