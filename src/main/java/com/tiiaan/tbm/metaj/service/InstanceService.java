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

    Result queryInstances(Integer curr);

    Result queryInstancesMe(Integer curr);

    Result watchInstance(Long id);

    Result queryInstanceWatching(Long id);

    Result queryInstancesCount();

    Result queryWatchingCount(Long id);

    Result queryIsWatchingByCurrUser(Long id);

}
