package com.tiiaan.tbm.metaj.service.impl;

import com.tiiaan.tbm.metaj.MetajApplication;
import com.tiiaan.tbm.metaj.dto.InstanceDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.dto.UserDTO;
import com.tiiaan.tbm.metaj.service.InstanceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class InstanceServiceImplTest {

    @Resource
    private InstanceService instanceService;

    @Test
    void registerInstance() {

        InstanceDTO instanceDTO = new InstanceDTO();
        instanceDTO.setProject("上海轨道交通99号线");
        instanceDTO.setSegments(53436);
        instanceDTO.setMileage(80154L);
        Result result = instanceService.registerInstance(instanceDTO);
        System.out.println(result.getData());

    }
}