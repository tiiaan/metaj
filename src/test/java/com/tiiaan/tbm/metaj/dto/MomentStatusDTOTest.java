package com.tiiaan.tbm.metaj.dto;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MomentStatusDTOTest {

    @Test
    public void test() {
        MomentStatusDTO momentStatusDTO = new MomentStatusDTO(System.currentTimeMillis(), 0.0);
        String json = JSONUtil.toJsonStr(momentStatusDTO);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(json);
        }
        System.out.println(json);
        String res = JSONUtil.toJsonStr(list);
        System.out.println(res);
    }

}