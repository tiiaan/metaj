package com.tiiaan.tbm.metaj.mapper;

import cn.hutool.json.JSONUtil;
import com.tiiaan.tbm.metaj.dto.CountDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class InstanceMapperTest {


    @Resource
    private InstanceMapper instanceMapper;

    @Test
    public void queryCountGroupByHealth() {
        List<CountDTO> countDTOS = instanceMapper.queryCountGroupByHealth();
        HashMap<Byte, Integer> res = new HashMap<>();
        for (CountDTO countDTO : countDTOS) {
            res.put(countDTO.getHealth(), countDTO.getCnt());
        }
        System.out.println(JSONUtil.toJsonStr(res));
    }

}