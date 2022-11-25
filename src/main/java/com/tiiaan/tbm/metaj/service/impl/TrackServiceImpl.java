package com.tiiaan.tbm.metaj.service.impl;

import com.tiiaan.tbm.metaj.mapper.TrackMapper;
import com.tiiaan.tbm.metaj.service.TrackService;
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
public class TrackServiceImpl implements TrackService {

    @Resource
    private TrackMapper trackMapper;

}
