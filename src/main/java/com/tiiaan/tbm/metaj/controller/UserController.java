package com.tiiaan.tbm.metaj.controller;

import cn.hutool.json.JSONUtil;
import com.tiiaan.tbm.metaj.dto.LoginFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginFormDTO loginFormDTO) {
        return userService.login(loginFormDTO);
    }

}
