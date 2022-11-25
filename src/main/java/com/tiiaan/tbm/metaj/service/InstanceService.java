package com.tiiaan.tbm.metaj.service;

import com.tiiaan.tbm.metaj.dto.InstanceDTO;
import com.tiiaan.tbm.metaj.dto.Result;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public interface InstanceService {

    Result registerInstance(InstanceDTO instanceDTO);

    Result queryInstanceById(Long id);

    Result watchInstance(Long id);

}
