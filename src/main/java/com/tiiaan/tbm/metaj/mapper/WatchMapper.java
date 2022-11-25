package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.Watch;
import com.tiiaan.tbm.metaj.entity.WatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WatchMapper {
    long countByExample(WatchExample example);

    int deleteByExample(WatchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Watch record);

    int insertSelective(Watch record);

    List<Watch> selectByExample(WatchExample example);

    Watch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Watch record, @Param("example") WatchExample example);

    int updateByExample(@Param("record") Watch record, @Param("example") WatchExample example);

    int updateByPrimaryKeySelective(Watch record);

    int updateByPrimaryKey(Watch record);
}