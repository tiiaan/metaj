package com.tiiaan.tbm.metaj.dto;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonitorDTOTest {

    @Test
    public void test() {

        MonitorDTO monitorDTO = MonitorDTO.builder()
                .timestamp(System.currentTimeMillis())
                .health((byte) 1)
                .mainTorque(152.5)
                .motorTorque(7.3)
                .mainForce(235.1)
                .asmPressure(21.5)
                .asmTemperature(66.2)
                .propPressure(23.9)
                .propTemperature(54.8)
                .bearTemperature(71.7)
                .bearBoltStrain(10.6).build();
        System.out.println(JSONUtil.toJsonStr(monitorDTO));
    }

}