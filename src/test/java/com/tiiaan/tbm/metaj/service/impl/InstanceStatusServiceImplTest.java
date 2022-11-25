package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.tiiaan.tbm.metaj.common.RedisConstants;
import com.tiiaan.tbm.metaj.dto.InstanceStatusDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.holder.InstanceHolder;
import com.tiiaan.tbm.metaj.service.InstanceStatusService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class InstanceStatusServiceImplTest {

    @Resource
    private InstanceStatusService instanceStatusService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void uploadStatus() {

        InstanceStatusDTO instanceStatusDTO = new InstanceStatusDTO();

        //String json = JSONUtil.toJsonStr(instanceStatusDTO);
        //System.out.println(json);

        String token = "853ba1fdafe14b4a8ca8b2d8b7165905";
        String key = RedisConstants.INSTANCE_TOKEN + token;
        String idStr = stringRedisTemplate.opsForValue().get(key);
        if (idStr == null) {
            return;
        }
        InstanceHolder.saveInstanceId(Long.valueOf(idStr));

        for (int i = 0; i < 1000; i++) {
            long ts = System.currentTimeMillis();
            instanceStatusDTO.setTimestamp(ts);
            instanceStatusDTO.setHealth((byte) 1);
            instanceStatusDTO.setMainTorque(1856.93 + RandomUtil.randomDouble(-100, 100));
            instanceStatusDTO.setMotorTorque(97.61 + RandomUtil.randomDouble(-10, 10));
            instanceStatusDTO.setMainForce(19362.77 + RandomUtil.randomDouble(-1000, 1000));
            instanceStatusDTO.setBiasForce(3376.54 + RandomUtil.randomDouble(-100, 100));
            instanceStatusDTO.setAsmPressure(89.12 + RandomUtil.randomDouble(-10, 10));
            instanceStatusDTO.setAsmTemperature(67.3 + RandomUtil.randomDouble(-10, 10));
            instanceStatusDTO.setPropPressure(76.52 + RandomUtil.randomDouble(-10, 10));
            instanceStatusDTO.setPropTemperature(73.5 + RandomUtil.randomDouble(-10, 10));
            instanceStatusDTO.setBearBoltStrain(0.0182 + RandomUtil.randomDouble(-0.1, 0.1));
            instanceStatusDTO.setBearTemperature(87.8 + RandomUtil.randomDouble(-10, 10));
            Result result = instanceStatusService.uploadStatus(instanceStatusDTO);
            log.info("[{}] {}", i, ts);
            try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}