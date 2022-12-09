package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.json.JSONUtil;
import com.tiiaan.tbm.metaj.dto.MomentStatusDTO;
import com.tiiaan.tbm.metaj.dto.MonitorDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.holder.InstanceHolder;
import com.tiiaan.tbm.metaj.holder.UserHolder;
import com.tiiaan.tbm.metaj.service.MonitorService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Set;

import static com.tiiaan.tbm.metaj.common.RedisConstants.*;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Service
public class MonitorServiceImpl implements MonitorService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public Result upload(MonitorDTO monitorDTO) {
        Long instanceId = InstanceHolder.getInstanceId();
        Long timestamp = monitorDTO.getTimestamp();
        uploadRedisZSet(STATUS_KEY + instanceId, JSONUtil.toJsonStr(monitorDTO), timestamp);
        return Result.ok();

        //uploadRedisZSet(
        //        STATUS_KEY + MAT + instanceId,
        //        JSONUtil.toJsonStr(new MomentStatusDTO(timestamp, monitorDTO.getMainTorque())),
        //        timestamp);
        //
        //uploadRedisZSet(
        //        STATUS_KEY + MOT + instanceId,
        //        JSONUtil.toJsonStr(new MomentStatusDTO(timestamp, monitorDTO.getMotorTorque())),
        //        timestamp);
        //
        //uploadRedisZSet(
        //        STATUS_KEY + MF + instanceId,
        //        JSONUtil.toJsonStr(new MomentStatusDTO(timestamp, monitorDTO.getMainForce())),
        //        timestamp);
        //
        //uploadRedisZSet(
        //        STATUS_KEY + BF + instanceId,
        //        JSONUtil.toJsonStr(new MomentStatusDTO(timestamp, monitorDTO.getBiasForce())),
        //        timestamp);
        //
        //uploadRedisZSet(
        //        STATUS_KEY + AP + instanceId,
        //        JSONUtil.toJsonStr(new MomentStatusDTO(timestamp, monitorDTO.getAsmPressure())),
        //        timestamp);
        //
        //uploadRedisZSet(
        //        STATUS_KEY + AT + instanceId,
        //        JSONUtil.toJsonStr(new MomentStatusDTO(timestamp, monitorDTO.getAsmTemperature())),
        //        timestamp);
        //
        //uploadRedisZSet(
        //        STATUS_KEY + PP + instanceId,
        //        JSONUtil.toJsonStr(new MomentStatusDTO(timestamp, monitorDTO.getPropPressure())),
        //        timestamp);
        //
        //uploadRedisZSet(
        //        STATUS_KEY + PT + instanceId,
        //        JSONUtil.toJsonStr(new MomentStatusDTO(timestamp, monitorDTO.getPropTemperature())),
        //        timestamp);
        //
        //uploadRedisZSet(
        //        STATUS_KEY + BT + instanceId,
        //        JSONUtil.toJsonStr(new MomentStatusDTO(timestamp, monitorDTO.getBearTemperature())),
        //        timestamp);
        //
        //uploadRedisZSet(
        //        STATUS_KEY + BB + instanceId,
        //        JSONUtil.toJsonStr(new MomentStatusDTO(timestamp, monitorDTO.getBearBoltStrain())),
        //        timestamp);

    }


    private void uploadRedisZSet(String key, String value, Long timestamp) {
        stringRedisTemplate.opsForZSet().add(key, value, timestamp);
        stringRedisTemplate.opsForZSet().removeRangeByScore(key, 0, timestamp - STATUS_TTL);
    }


    @Override
    public Result get(Long id, Long len) {
        String key = STATUS_KEY + id;
        long current = System.currentTimeMillis();
        Set<String> strings = stringRedisTemplate.opsForZSet().rangeByScore(key, current - len, current);
        if (strings == null || strings.isEmpty()) {
            return Result.ok(Collections.emptySet());
        }
        return Result.ok(strings);
    }


    @Override
    public Result push() {
        return Result.ok();
    }

}
