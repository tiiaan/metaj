package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.tiiaan.tbm.metaj.cache.CacheClient;
import com.tiiaan.tbm.metaj.dto.InstanceFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.Instance;
import com.tiiaan.tbm.metaj.entity.Segment;
import com.tiiaan.tbm.metaj.mapper.InstanceMapper;
import com.tiiaan.tbm.metaj.service.InstanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiiaan.tbm.metaj.service.SegmentService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import static com.tiiaan.tbm.metaj.common.Constants.*;
import static com.tiiaan.tbm.metaj.common.RedisConstants.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
@Service
public class InstanceServiceImpl extends ServiceImpl<InstanceMapper, Instance> implements InstanceService {

    @Resource
    private CacheClient cacheClient;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SegmentService segmentService;


    @Override
    public Result queryInstanceById(Long id) {
        //return Result.ok(getById(id));
        Instance instance = cacheClient.queryWithMutex(
                CACHE_INSTANCE_KEY, id, Instance.class, this::getById, CACHE_INSTANCE_TTL, TTL_UNIT);
        return Result.ok(instance);
    }


    @Transactional
    @Override
    public Result addInstance(InstanceFormDTO instanceFormDTO) {
        Instance instance = BeanUtil.copyProperties(instanceFormDTO, Instance.class);
        instance.setName(RandomUtil.randomString(INSTANCE_NAME_LEN));
        save(instance);
        segmentService.save(new Segment(instance));
        Long id = instance.getId();
        String token = UUID.randomUUID().toString(true);
        String key = INSTANCE_TOKEN + token;
        stringRedisTemplate.opsForValue().set(key, id.toString());
        return Result.ok(token);
    }

}
