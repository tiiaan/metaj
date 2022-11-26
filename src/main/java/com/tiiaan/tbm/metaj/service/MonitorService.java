package com.tiiaan.tbm.metaj.service;

import com.tiiaan.tbm.metaj.dto.MonitorDTO;
import com.tiiaan.tbm.metaj.dto.Result;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public interface MonitorService {

    Result upload(MonitorDTO monitorDTO);

    Result get(Long id, Long len);

    Result push();

}
