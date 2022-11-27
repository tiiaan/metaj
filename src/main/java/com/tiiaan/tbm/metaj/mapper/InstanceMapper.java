package com.tiiaan.tbm.metaj.mapper;

import com.tiiaan.tbm.metaj.dto.CountDTO;
import com.tiiaan.tbm.metaj.entity.Instance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

}
