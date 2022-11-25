package com.tiiaan.tbm.metaj.service.impl;

import com.tiiaan.tbm.metaj.mapper.WatchMapper;
import com.tiiaan.tbm.metaj.service.WatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Slf4j
@Service
public class WatchServiceImpl implements WatchService {

    @Resource
    private WatchMapper watchMapper;

}
