package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tiiaan.tbm.metaj.cache.CacheClient;
import com.tiiaan.tbm.metaj.dto.CountDTO;
import com.tiiaan.tbm.metaj.dto.InstanceFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.dto.UserDTO;
import com.tiiaan.tbm.metaj.entity.Instance;
import com.tiiaan.tbm.metaj.entity.Segment;
import com.tiiaan.tbm.metaj.entity.Watch;
import com.tiiaan.tbm.metaj.exception.ErrorEnum;
import com.tiiaan.tbm.metaj.holder.UserHolder;
import com.tiiaan.tbm.metaj.mapper.InstanceMapper;
import com.tiiaan.tbm.metaj.service.InstanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiiaan.tbm.metaj.service.SegmentService;
import com.tiiaan.tbm.metaj.service.UserService;
import com.tiiaan.tbm.metaj.service.WatchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
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
        return Result.ok(getInstanceByIdFromCache(id));
        //return Result.ok(getById(id));
        //Instance instance = cacheClient.queryWithMutex(
        //        CACHE_INSTANCE_KEY, id, Instance.class, this::getById, CACHE_INSTANCE_TTL, TTL_UNIT);
        //fillInstanceWatching(instance);
    }



    @Transactional
    @Override
    public Result addInstance(InstanceFormDTO instanceFormDTO) {
        Instance instance = BeanUtil.copyProperties(instanceFormDTO, Instance.class);
        instance.setName(RandomUtil.randomString(INSTANCE_NAME_LEN));
        //Long userId = UserHolder.getUser().getId();
        //instance.setUserId(userId);
        instance.setHealth(new Random().nextInt(4));
        save(instance);
        segmentService.save(new Segment(instance));
        Long id = instance.getId();
        String token = UUID.randomUUID().toString(true);
        String key = INSTANCE_TOKEN + token;
        stringRedisTemplate.opsForValue().set(key, id.toString());
        return Result.ok(token);
    }



    /**
     * 带缓存的分页查询
     * @param curr
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    //@Override
    //public Result queryInstances(Integer curr) {
    //    //先去缓存取
    //    String key = CACHE_INSTANCES_PAGE + curr;
    //    String json = stringRedisTemplate.opsForValue().get(key);
    //    if (json != null && json.length() != 0) {
    //        log.info("cache");
    //        List<Instance> instances = JSONUtil.toList(json, Instance.class);
    //        instances.forEach(this::fillInstanceWatching);
    //        return Result.ok(instances);
    //    }
    //    if (json != null) {
    //        return null;
    //    }
    //    //如果缓存中没有，就去查询
    //    Page<Instance> page = this.query().page(new Page<>(curr, INSTANCE_PAGE_SIZE));
    //    if (page == null) {
    //        stringRedisTemplate.opsForValue().set(key, "", 120L, TTL_UNIT);
    //        return null;
    //    }
    //    List<Instance> instances = page.getRecords();
    //    //补充当前用户的watch信息
    //    instances.forEach(this::fillInstanceWatching);
    //    stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(instances), CACHE_INSTANCES_PAGE_TTL, TTL_UNIT);
    //    return Result.ok(instances);
    //}




    @Override
    public Result queryInstances(Integer curr,
                                 String orderBy,
                                 Integer orderType,
                                 Integer health,
                                 Boolean watching,
                                 Boolean ofMe) {
        Long userId = UserHolder.getUser().getId();
        List<Long> idSet = null;
        if (watching) {
            String key = USER_WATCHING_KEY + userId;
            Set<String> idStrs = stringRedisTemplate.opsForSet().members(key);
            if (idStrs == null || idStrs.isEmpty()) {
                return Result.ok(Collections.emptyList());
            }
            idSet = idStrs.stream().map(Long::valueOf).collect(Collectors.toList());
        }
        String type = orderType == 0 ? "ASC" : "DESC";
        Integer start = (curr - 1) * INSTANCE_PAGE_SIZE;
        userId = ofMe ? userId : -1;
        List<Long> ids = instanceMapper.queryIdsDynamic(
                idSet,
                start,
                INSTANCE_PAGE_SIZE,
                orderBy, type,
                health,
                userId);
        ArrayList<Instance> instances = new ArrayList<>();
        for (Long id : ids) {
            instances.add(this.getInstanceByIdFromCache(id));
        }
        return Result.ok(instances);
    }



    public Result queryInstancesOrderBy(Integer curr, String byWhat, Integer health) {
        //先去缓存取
        //String key = CACHE_INSTANCES_PAGE + curr;
        //String json = stringRedisTemplate.opsForValue().get(key);
        //if (json != null && json.length() != 0) {
        //    log.info("cache");
        //    List<Instance> instances = JSONUtil.toList(json, Instance.class);
        //    instances.forEach(this::fillInstanceWatching);
        //    return Result.ok(instances);
        //}
        //if (json != null) {
        //    return null;
        //}
        List<Long> ids = null;
        if (health == -1) {
            ids = instanceMapper.queryIdsOrderBy((curr - 1) * INSTANCE_PAGE_SIZE, INSTANCE_PAGE_SIZE, byWhat);
        } else {
            ids = instanceMapper.queryIdsOrderByWithHealth((curr - 1) * INSTANCE_PAGE_SIZE, INSTANCE_PAGE_SIZE, byWhat, health);
        }
        ArrayList<Instance> instances = new ArrayList<>();
        for (Long id : ids) {
            instances.add(this.getInstanceByIdFromCache(id));
        }
        return Result.ok(instances);
        //
        ////如果缓存中没有，就去查询
        //Page<Instance> page = this.query().page(new Page<>(curr, INSTANCE_PAGE_SIZE));
        //if (page == null) {
        //    stringRedisTemplate.opsForValue().set(key, "", 120L, TTL_UNIT);
        //    return null;
        //}
        //List<Instance> instances = page.getRecords();
        ////补充当前用户的watch信息
        //instances.forEach(this::fillInstanceWatching);
        //stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(instances), CACHE_INSTANCES_PAGE_TTL, TTL_UNIT);
        //return Result.ok(instances);
    }


    private Instance getInstanceByIdFromCache(Long id) {
        Instance instance = cacheClient.queryWithMutex(
                CACHE_INSTANCE_KEY, id, Instance.class, this::getById, CACHE_INSTANCE_TTL, TTL_UNIT);
        fillInstanceWatching(instance);
        return instance;
    }


    public Result queryInstancesMe(Integer curr, String byWhat, Integer health) {
        Long userId = UserHolder.getUser().getId();
        String key = USER_WATCHING_KEY + userId;
        Set<String> idStrs = stringRedisTemplate.opsForSet().members(key);
        if (idStrs == null || idStrs.isEmpty()) {
            return Result.ok(Collections.emptyList());
        }
        List<Long> ids = idStrs.stream().map(Long::valueOf).collect(Collectors.toList());

        List<Long> idsRes = null;
        if (health == -1) {
            idsRes = instanceMapper.queryIdsOfMeOrderBy(ids, (curr - 1) * INSTANCE_PAGE_SIZE, INSTANCE_PAGE_SIZE, byWhat);
        } else {
            idsRes = instanceMapper.queryIdsOfMeOrderByWithHealth(ids, (curr - 1) * INSTANCE_PAGE_SIZE, INSTANCE_PAGE_SIZE, byWhat, health);
        }
        ArrayList<Instance> instances = new ArrayList<>();
        for (Long id : idsRes) {
            instances.add(this.getInstanceByIdFromCache(id));
        }
        return Result.ok(instances);

        //Page<Instance> page = this.query().in("id", ids).page(new Page<>(curr, INSTANCE_PAGE_SIZE));
        //List<Instance> instances = page.getRecords();
        //instances.forEach(this::fillInstanceWatching);
        //return Result.ok(instances);
    }





    private void fillInstanceWatching(Instance instance) {
        Long userId = UserHolder.getUser().getId();
        //String key = INSTANCE_WATCHING_KEY + instance.getId();
        //Double score = stringRedisTemplate.opsForZSet().score(key, userId.toString());
        //instance.setIsWatching(score != null);
        Long id = instance.getId();
        instance.setIsWatching((Boolean) this.queryIsWatchingByCurrUser(id).getData());
        instance.setWatching((Integer) this.queryWatchingCount(id).getData());
    }



    //@Transactional
    //@Override
    //public Result watchInstance(Long id) {
    //    Long userId = UserHolder.getUser().getId();
    //    String instKey = INSTANCE_WATCHING_KEY + id;
    //    String userKey = USER_WATCHING_KEY + userId;
    //    //Double score = stringRedisTemplate.opsForZSet().score(instKey, userId.toString());
    //    Boolean watched = stringRedisTemplate.opsForSet().isMember(userKey, id.toString());
    //    if (Boolean.FALSE.equals(watched)) {
    //        watchService.save(new Watch(userId, id));
    //        update().setSql("watching = watching + 1").eq("id", id).update();
    //        stringRedisTemplate.opsForZSet().add(instKey, userId.toString(), System.currentTimeMillis());
    //        stringRedisTemplate.opsForSet().add(userKey, id.toString());
    //        log.info("user [{}] watch instance [{}]", userId, id);
    //    } else {
    //        watchService.remove(new QueryWrapper<Watch>().eq("user_id", userId).eq("instance_id", id));
    //        update().setSql("watching = watching - 1").eq("id", id).update();
    //        stringRedisTemplate.opsForZSet().remove(instKey, userId.toString());
    //        stringRedisTemplate.opsForSet().remove(userKey, id.toString());
    //        log.info("user [{}] unwatch instance [{}]", userId, id);
    //    }
    //    return Result.ok();
    //}




    @Transactional
    @Override
    public Result watchInstance(Long id) {
        //获取用户
        Long userId = UserHolder.getUser().getId();
        String userKey = USER_WATCHING_KEY + userId;
        String instKey = INSTANCE_WATCHING_KEY + id;
        //判断用户是否已经关注过了
        Boolean watched = stringRedisTemplate.opsForSet().isMember(userKey, id.toString());
        if (Boolean.FALSE.equals(watched)) {
            //watchService.save(new Watch(userId, id));
            //update().setSql("watching = watching + 1").eq("id", id).update();
            //stringRedisTemplate.opsForZSet().add(instKey, userId.toString(), System.currentTimeMillis());
            stringRedisTemplate.opsForValue().increment(instKey);
            stringRedisTemplate.opsForSet().add(userKey, id.toString());
            log.info("user [{}] watch instance [{}]", userId, id);
        } else {
            //watchService.remove(new QueryWrapper<Watch>().eq("user_id", userId).eq("instance_id", id));
            //update().setSql("watching = watching - 1").eq("id", id).update();
            //stringRedisTemplate.opsForZSet().remove(instKey, userId.toString());
            stringRedisTemplate.opsForSet().remove(userKey, id.toString());
            stringRedisTemplate.opsForValue().decrement(instKey);
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



    @Override
    public Result queryWatchingCount(Long id) {
        String instKey = INSTANCE_WATCHING_KEY + id;
        String str = stringRedisTemplate.opsForValue().get(instKey);
        if (str != null && str.length() != 0) {
            return Result.ok(Integer.valueOf(str));
        }
        Integer count = getById(id).getWatching();
        return Result.ok(count);
    }



    @Override
    public Result queryIsWatchingByCurrUser(Long id) {
        Long userId = UserHolder.getUser().getId();
        String userKey = USER_WATCHING_KEY + userId;
        Boolean watched = stringRedisTemplate.opsForSet().isMember(userKey, id.toString());
        if (watched != null) {
            return Result.ok(Boolean.TRUE.equals(watched));
        }
        Integer count = watchService.query().eq("user_id", userId).eq("instance_id", id).count();
        return Result.ok(count != 0);
    }




    @Override
    public Result queryIssuesCount(Long instanceId) {
        Instance instance = getById(instanceId);
        ErrorEnum.DB_QUERY_FAIL.assertNotNull(instance);
        return Result.ok(instance.getIssues());
    }


}
