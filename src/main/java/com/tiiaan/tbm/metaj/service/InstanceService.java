package com.tiiaan.tbm.metaj.service;

import com.tiiaan.tbm.metaj.dto.InstanceFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.Instance;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
public interface InstanceService extends IService<Instance> {

    Result queryInstanceById(Long id);

    Result addInstance(InstanceFormDTO instanceFormDTO);

}
