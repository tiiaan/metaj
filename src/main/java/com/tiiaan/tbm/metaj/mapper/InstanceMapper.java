package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.dto.CountDTO;
import com.tiiaan.tbm.metaj.entity.Instance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
public interface InstanceMapper extends BaseMapper<Instance> {

    List<CountDTO> queryCountGroupByHealth();

    List<Long> queryIdsOrderByWithHealth(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("byWhat") String byWhat, @Param("health") Integer health);

    List<Long> queryIdsOfMeOrderByWithHealth(@Param("idSet")List<Long> idSet, @Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("byWhat") String byWhat, @Param("health") Integer health);

    List<Long> queryIdsOrderBy(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("byWhat") String byWhat);

    List<Long> queryIdsOfMeOrderBy(@Param("idSet")List<Long> idSet, @Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("byWhat") String byWhat);

    List<Long> queryIdsDynamic(@Param("idSet")List<Long> idSet, @Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("orderBy") String orderBy, @Param("orderType") String orderType, @Param("health") Integer health, @Param("userId") Long userId);
}
