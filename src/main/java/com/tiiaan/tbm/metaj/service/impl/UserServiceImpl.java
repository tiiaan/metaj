package com.tiiaan.tbm.metaj.service.impl;

import com.tiiaan.tbm.metaj.entity.User;
import com.tiiaan.tbm.metaj.mapper.UserMapper;
import com.tiiaan.tbm.metaj.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
