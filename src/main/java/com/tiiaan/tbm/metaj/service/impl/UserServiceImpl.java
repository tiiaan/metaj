package com.tiiaan.tbm.metaj.service.impl;

import com.tiiaan.tbm.metaj.mapper.UserMapper;
import com.tiiaan.tbm.metaj.service.UserService;

import javax.annotation.Resource;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

}
