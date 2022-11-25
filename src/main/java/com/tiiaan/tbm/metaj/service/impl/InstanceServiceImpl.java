package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.tiiaan.tbm.metaj.cache.CacheClient;
import com.tiiaan.tbm.metaj.dto.InstanceDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.dto.UserDTO;
import com.tiiaan.tbm.metaj.entity.Instance;
import com.tiiaan.tbm.metaj.entity.InstanceExample;
import com.tiiaan.tbm.metaj.holder.UserHolder;
import com.tiiaan.tbm.metaj.mapper.InstanceMapper;
import com.tiiaan.tbm.metaj.service.InstanceService;
import com.tiiaan.tbm.metaj.service.WatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import static com.tiiaan.tbm.metaj.common.RedisConstants.*;
import static com.tiiaan.tbm.metaj.common.RedisConstants.CACHE_INSTANCE_TTL;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Slf4j
@Service
public class InstanceServiceImpl implements InstanceService {

    @Resource
    private InstanceMapper instanceMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private CacheClient cacheClient;
    @Resource
    private WatchService watchService;


    @Override
    public Result registerInstance(InstanceDTO instanceDTO) {

        //TODO 注册校验
        //Long userId = UserHolder.getUser().getId();
        //String code = instanceDTO.getCode();
        //if (code == null || code.length() == 0) {
        //    return Result.fail("未授权");
        //}
        //String codeKey = userId
        //stringRedisTemplate.opsForValue().get();

        //向数据库插入一条记录
        Instance instance = new Instance();
        instance.setName(RandomUtil.randomString(16));
        instance.setProject(instanceDTO.getProject());
        instance.setMileage(instanceDTO.getMileage());
        instance.setSegments(instanceDTO.getSegments());
        instanceMapper.insertSelective(instance);
        //获取自增id
        Long id = instance.getId();
        if (id == null) {
            return Result.fail("注册失败");
        }
        //生成token
        String token = UUID.randomUUID().toString(true);
        //将token和id存到redis中用于数据上传接口校验
        String key = INSTANCE_TOKEN + token;
        stringRedisTemplate.opsForValue().set(key, id.toString());
        //返回token给客户端
        return Result.ok(token);
    }



    @Override
    public Result queryInstanceById(Long id) {
        //return Result.ok(instanceMapper.selectByPrimaryKey(id));
        Instance instance = cacheClient.queryWithMutex(
                CACHE_INSTANCE_KEY, id, Instance.class, instanceMapper::selectByPrimaryKey, CACHE_INSTANCE_TTL, TTL_UNIT);
        return Result.ok(instance);
    }



    @Override
    public Result watchInstance(Long id) {
        Long userId = UserHolder.getUser().getId();
        String key = INSTANCE_WATCHING_KEY + id;
        Double score = stringRedisTemplate.opsForZSet().score(key, userId.toString());
        //如果没有关注
        if (score == null) {
            int isSuccess = instanceMapper.updateWatchingPlusById(id);
            if (isSuccess > 0) {
                stringRedisTemplate.opsForZSet().add(key, userId.toString(), System.currentTimeMillis());
            }
        } else {
            int isSuccess = instanceMapper.updateWatchingDownById(id);
            if (isSuccess > 0) {
                stringRedisTemplate.opsForZSet().remove(key, userId.toString());
            }
        }
        return Result.ok();
    }

}
