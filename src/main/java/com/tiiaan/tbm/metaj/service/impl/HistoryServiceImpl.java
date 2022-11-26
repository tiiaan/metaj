package com.tiiaan.tbm.metaj.service.impl;

import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.History;
import com.tiiaan.tbm.metaj.mapper.HistoryMapper;
import com.tiiaan.tbm.metaj.service.HistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
@Service
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History> implements HistoryService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result stub(Long id) {
        long current = System.currentTimeMillis();
        //stringRedisTemplate.opsForZSet()
        return Result.ok();
    }

}
