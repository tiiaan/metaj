package com.tiiaan.tbm.metaj.holder;

import com.tiiaan.tbm.metaj.common.RedisConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InstanceHolderTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void saveInstanceId() {
        String token = "853ba1fdafe14b4a8ca8b2d8b7165905";
        String key = RedisConstants.INSTANCE_TOKEN + token;
        String idStr = stringRedisTemplate.opsForValue().get(key);
        if (idStr == null) {
            return;
        }
        InstanceHolder.saveInstanceId(Long.valueOf(idStr));
    }
}