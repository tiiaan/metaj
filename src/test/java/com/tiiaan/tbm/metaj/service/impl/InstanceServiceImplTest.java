package com.tiiaan.tbm.metaj.service.impl;

import com.tiiaan.tbm.metaj.dto.InstanceFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.InstanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Random;

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
        //InstanceFormDTO instance = InstanceFormDTO.builder().project("上海地铁轨道交通 86 号线 (东线) 中铁建 3572 号")
        //        .segments(53672).mileage(80508L).longitude(31.002778).latitude(121.006111).build();

        //InstanceFormDTO instance = InstanceFormDTO.builder().project("上海地铁轨道交通机场联络线 隧道股份 1501 号")
        //        .segments(33628).mileage(50442L).longitude(27.105632).latitude(131.016138).build();

        //InstanceFormDTO instance = InstanceFormDTO.builder().project("上海黄浦江银都路隧道 市政建设 6358 号")
        //        .segments(6386).mileage(9579L).longitude(47.532772).latitude(109.124219).build();


        Random random = new Random();

        String[] names = {
                "苏州地铁轨道交通 82 号线 (左线) 中铁装备 2918 号",
                "上海地铁 92 号线 隧道股份 2018 号",
                "苏州地铁轨道交通 66 号线三期 中铁装备 2111 号",
                "崇明岛隧道 隧道股份 2282 号",
                "上海地铁轨道交通 85 号线 隧道股份 2256 号",
                "苏州地铁轨道交通 90 号线 (西环线) 市政 156 号",
                "莫干山隧道二期工程 中国铁建 8801 号",
        };

        for (int i = 0; i < 7; i++) {
            int count = random.nextInt(50000) + 9000;
            InstanceFormDTO instance = InstanceFormDTO.builder().project(names[i])
                    .segments(count).mileage((Long) Math.round(count * 1.5)).longitude(30.532772 + random.nextInt(15)).latitude(120.124219 + random.nextInt(15)).build();
            Result result = instanceService.addInstance(instance);
            System.out.println(result.getData());
        }

    }
}