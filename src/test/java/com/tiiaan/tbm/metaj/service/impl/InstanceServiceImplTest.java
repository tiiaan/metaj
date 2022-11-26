package com.tiiaan.tbm.metaj.service.impl;

import com.tiiaan.tbm.metaj.dto.InstanceFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.InstanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;



@SpringBootTest
@RunWith(SpringRunner.class)
public class InstanceServiceImplTest {

    @Resource
    private InstanceService instanceService;

    @Test
    public void queryInstanceById() {
    }

    @Test
    public void addInstance() {
        InstanceFormDTO instance = InstanceFormDTO.builder().project("上海地铁轨道交通 86 号线 (东线) 中铁建 3572 号")
                .segments(53672).mileage(80508L).longitude(31.002778).latitude(121.006111).build();
        Result result = instanceService.addInstance(instance);
        System.out.println(result.getData());
    }
}