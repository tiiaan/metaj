package com.tiiaan.tbm.metaj.service.impl;

import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SystemServiceImplTest {


    @Resource
    private SystemService systemService;


    @Test
    public void querySystemProcessor() {
        while (true) {
            Result result = systemService.querySystemProcessor();
            log.info("cpu=[{}]", result.getData().toString());
            try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}