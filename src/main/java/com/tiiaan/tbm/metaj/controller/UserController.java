package com.tiiaan.tbm.metaj.controller;


import com.tiiaan.tbm.metaj.dto.LoginFormDTO;
import com.tiiaan.tbm.metaj.dto.RegisterFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
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

    @PostMapping("/register")
    public Result register(@RequestBody RegisterFormDTO registerFormDTO) {
        return userService.register(registerFormDTO);
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        String token = request.getHeader("authorization");
        return userService.logout(token);
    }

    @GetMapping("/me")
    public Result me() {
        return userService.me();
    }

    @GetMapping("/{id}")
    public Result queryUserById(@PathVariable("id") Long id) {
        return userService.queryUserById(id);
    }

}
