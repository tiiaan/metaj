package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tiiaan.tbm.metaj.cache.CacheClient;
import com.tiiaan.tbm.metaj.dto.CountDTO;
import com.tiiaan.tbm.metaj.dto.InstanceFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.dto.UserDTO;
import com.tiiaan.tbm.metaj.entity.Instance;
import com.tiiaan.tbm.metaj.entity.Segment;
import com.tiiaan.tbm.metaj.entity.Watch;
import com.tiiaan.tbm.metaj.holder.UserHolder;
import com.tiiaan.tbm.metaj.mapper.InstanceMapper;
import com.tiiaan.tbm.metaj.service.InstanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiiaan.tbm.metaj.service.SegmentService;
import com.tiiaan.tbm.metaj.service.UserService;
import com.tiiaan.tbm.metaj.service.WatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static com.tiiaan.tbm.metaj.common.SysConstants.*;
import static com.tiiaan.tbm.metaj.common.RedisConstants.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */

@Slf4j
@Service
public class InstanceServiceImpl extends ServiceImpl<InstanceMapper, Instance> implements InstanceService {

    @Resource
    private CacheClient cacheClient;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private SegmentService segmentService;
    @Resource
    private WatchService watchService;
    @Resource
    private UserService userService;
    @Resource
    private InstanceMapper instanceMapper;


    @Override
    public Result queryInstanceById(Long id) {
        //return Result.ok(getById(id));
        Instance instance = getById(id);
        //Instance instance = cacheClient.queryWithMutex(
        //        CACHE_INSTANCE_KEY, id, Instance.class, this::getById, CACHE_INSTANCE_TTL, TTL_UNIT);
        fillInstanceWatching(instance);
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


    @Override
    public Result queryInstances(Integer curr) {
        //查询
        Page<Instance> page = this.query().page(new Page<>(curr, INSTANCE_PAGE_SIZE));
        List<Instance> instances = page.getRecords();
        //补充当前用户的watch信息
        instances.forEach(this::fillInstanceWatching);
        return Result.ok(instances);
    }



    @Override
    public Result queryInstancesMe(Integer curr) {
        Long userId = UserHolder.getUser().getId();
        String key = USER_WATCHING_KEY + userId;
        Set<String> idStrs = stringRedisTemplate.opsForSet().members(key);
        if (idStrs == null || idStrs.isEmpty()) {
            return Result.ok(Collections.emptyList());
        }
        List<Long> ids = idStrs.stream().map(Long::valueOf).collect(Collectors.toList());
        Page<Instance> page = this.query().in("id", ids).page(new Page<>(curr, INSTANCE_PAGE_SIZE));
        List<Instance> instances = page.getRecords();
        instances.forEach(this::fillInstanceWatching);
        return Result.ok(instances);
    }



    private void fillInstanceWatching(Instance instance) {
        Long userId = UserHolder.getUser().getId();
        String key = INSTANCE_WATCHING_KEY + instance.getId();
        Double score = stringRedisTemplate.opsForZSet().score(key, userId.toString());
        instance.setIsWatching(score != null);
    }



    @Transactional
    @Override
    public Result watchInstance(Long id) {
        Long userId = UserHolder.getUser().getId();
        String instKey = INSTANCE_WATCHING_KEY + id;
        String userKey = USER_WATCHING_KEY + userId;
        //Double score = stringRedisTemplate.opsForZSet().score(instKey, userId.toString());
        Boolean watched = stringRedisTemplate.opsForSet().isMember(userKey, id.toString());
        if (Boolean.FALSE.equals(watched)) {
            watchService.save(new Watch(userId, id));
            update().setSql("watching = watching + 1").eq("id", id).update();
            stringRedisTemplate.opsForZSet().add(instKey, userId.toString(), System.currentTimeMillis());
            stringRedisTemplate.opsForSet().add(userKey, id.toString());
            log.info("user [{}] watch instance [{}]", userId, id);
        } else {
            watchService.remove(new QueryWrapper<Watch>().eq("user_id", userId).eq("instance_id", id));
            update().setSql("watching = watching - 1").eq("id", id).update();
            stringRedisTemplate.opsForZSet().remove(instKey, userId.toString());
            stringRedisTemplate.opsForSet().remove(userKey, id.toString());
            log.info("user [{}] unwatch instance [{}]", userId, id);
        }
        return Result.ok();
    }


    @Override
    public Result queryInstanceWatching(Long id) {
        String key = INSTANCE_WATCHING_KEY + id;
        Set<String> idStrs = stringRedisTemplate.opsForZSet().range(key, 0, 5);
        if (idStrs == null || idStrs.isEmpty()) {
            return Result.ok(Collections.emptyList());
        }
        List<Long> ids = idStrs.stream().map(Long::valueOf).collect(Collectors.toList());
        String idsStr = StrUtil.join(",", ids);
        List<UserDTO> users = userService.query().in("id", ids)
                .last("ORDER BY FIELD(id," + idsStr + ")").list()
                .stream().map(user -> BeanUtil.copyProperties(user, UserDTO.class))
                .collect(Collectors.toList());
        return Result.ok(users);
    }


    @Override
    public Result queryInstancesCount() {
        //0停机, 1健康, 2报警, 3故障
        List<CountDTO> countDTOS = instanceMapper.queryCountGroupByHealth();
        HashMap<String, Integer> map = new HashMap<>();
        for (CountDTO countDTO : countDTOS) {
            map.put("h" + countDTO.getHealth(), countDTO.getCnt());
        }
        return Result.ok(map);
    }


}
