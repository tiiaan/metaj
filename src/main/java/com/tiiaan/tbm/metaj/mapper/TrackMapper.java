package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.Track;
import com.tiiaan.tbm.metaj.entity.TrackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrackMapper {
    long countByExample(TrackExample example);

    int deleteByExample(TrackExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Track record);

    int insertSelective(Track record);

    List<Track> selectByExample(TrackExample example);

    Track selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Track record, @Param("example") TrackExample example);

    int updateByExample(@Param("record") Track record, @Param("example") TrackExample example);

    int updateByPrimaryKeySelective(Track record);

    int updateByPrimaryKey(Track record);
}