package com.tiiaan.tbm.metaj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tiiaan.tbm.metaj.dto.LoginFormDTO;
import com.tiiaan.tbm.metaj.dto.RegisterFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.dto.UserDTO;
import com.tiiaan.tbm.metaj.entity.User;
import com.tiiaan.tbm.metaj.holder.UserHolder;
import com.tiiaan.tbm.metaj.mapper.UserMapper;
import com.tiiaan.tbm.metaj.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiiaan.tbm.metaj.util.PasswordEncoder;
import com.tiiaan.tbm.metaj.util.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.tiiaan.tbm.metaj.common.RedisConstants.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public Result login(LoginFormDTO loginFormDTO) {
        String name = loginFormDTO.getName();
        String pwd = loginFormDTO.getPwd();
        User user = getOne(new QueryWrapper<User>().eq("name", name));
        if (user == null) {
            log.info("user not found");
            return Result.fail("user not found");
        }
        Boolean isMatch = PasswordEncoder.matches(user.getPwd(), pwd);
        if (Boolean.FALSE.equals(isMatch)) {
            log.info("error password");
            return Result.fail("error password");
        }
        String token = UUID.randomUUID().toString(true);
        String key = USER_TOKEN + token;
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        Map<String, Object> userMap = BeanUtil.beanToMap(userDTO, new HashMap<>(),
                CopyOptions.create()
                        .setIgnoreNullValue(true)
                        .setFieldValueEditor((fieldName, fieldValue) -> fieldValue.toString()));
        stringRedisTemplate.opsForHash().putAll(key, userMap);
        stringRedisTemplate.expire(key, USER_TOKEN_TTL, TTL_UNIT);
        log.info("user login successfully [{}]", token);
        return Result.ok(token);
    }


    @Override
    public Result register(RegisterFormDTO registerFormDTO) {
        String name = registerFormDTO.getName();
        String pwd = registerFormDTO.getPwd();
        registerFormDTO.setPwd(PasswordEncoder.encode(pwd));

        User user = BeanUtil.copyProperties(registerFormDTO, User.class);
        save(user);
        return null;
    }


    @Override
    public Result logout(String token) {
        String key = USER_TOKEN + token;
        stringRedisTemplate.delete(key);
        return Result.ok();
    }


    @Override
    public Result me() {
        UserDTO user = UserHolder.getUser();
        return Result.ok(user);
    }


    @Override
    public Result queryUserById(Long id) {
        User user = getById(id);
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        return Result.ok(userDTO);
    }

}
