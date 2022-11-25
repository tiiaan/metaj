package com.tiiaan.tbm.metaj.service;

import com.tiiaan.tbm.metaj.dto.InstanceStatusDTO;
import com.tiiaan.tbm.metaj.dto.Result;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public interface InstanceStatusService {
    Result queryStatus(Long id);

    Result uploadStatus(InstanceStatusDTO instanceStatusDTO);

}
