package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.entity.Instance;
import com.tiiaan.tbm.metaj.entity.InstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface InstanceMapper {
    long countByExample(InstanceExample example);

    int deleteByExample(InstanceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Instance record);

    int insertSelective(Instance record);

    List<Instance> selectByExample(InstanceExample example);

    Instance selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Instance record, @Param("example") InstanceExample example);

    int updateByExample(@Param("record") Instance record, @Param("example") InstanceExample example);

    int updateByPrimaryKeySelective(Instance record);

    int updateByPrimaryKey(Instance record);


    @Update("update tb_insatnce set watching = watching + 1 where id = #{id}")
    int updateWatchingPlusById(@Param("id") Long id);

    @Update("update tb_insatnce set watching = watching - 1 where id = #{id}")
    int updateWatchingDownById(@Param("id") Long id);

}