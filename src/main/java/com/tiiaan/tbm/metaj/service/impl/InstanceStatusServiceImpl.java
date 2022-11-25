package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.json.JSONUtil;
import com.tiiaan.tbm.metaj.dto.InstanceStatusDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.holder.InstanceHolder;
import com.tiiaan.tbm.metaj.service.InstanceStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.tiiaan.tbm.metaj.common.RedisConstants.*;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Slf4j
@Service
public class InstanceStatusServiceImpl implements InstanceStatusService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryStatus(Long id) {
        return null;
    }


    @Override
    public Result uploadStatus(InstanceStatusDTO instanceStatusDTO) {
        Long instanceId = InstanceHolder.getInstanceId();
        String key = STATUS_KEY + instanceId;
        Long timestamp = instanceStatusDTO.getTimestamp();
        stringRedisTemplate.opsForZSet().add(key, JSONUtil.toJsonStr(instanceStatusDTO), timestamp);
        stringRedisTemplate.opsForZSet().removeRangeByScore(key, 0, timestamp - STATUS_TTL);
        return Result.ok();
    }

}
