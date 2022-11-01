package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.tiiaan.tbm.metaj.dto.RegisterFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void login() {
    }


    @Test
    public void register() {
        RegisterFormDTO registerFormDTO = new RegisterFormDTO();
        registerFormDTO.setAvatar("/img/avatar/default_avatar.png");
        registerFormDTO.setName("root");
        registerFormDTO.setPwd("root");
        registerFormDTO.setPhone("15938628261");
        registerFormDTO.setEmail("root@metaj.com");
        registerFormDTO.setDept("后台");
        registerFormDTO.setRole("管理员");
        Result register = userService.register(registerFormDTO);
        System.out.println(register.getData());
    }



    @Test
    public void logout() {
    }

    @Test
    public void me() {
    }

    @Test
    public void queryUserById() {
    }
    
}