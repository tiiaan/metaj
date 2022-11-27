package com.tiiaan.tbm.metaj.service;

import com.tiiaan.tbm.metaj.dto.LoginFormDTO;
import com.tiiaan.tbm.metaj.dto.RegisterFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
public interface UserService extends IService<User> {

    Result login(LoginFormDTO loginFormDTO);

    Result register(RegisterFormDTO registerFormDTO);

    Result logout(String token);

    Result me();

    Result queryUserById(Long id);

}
