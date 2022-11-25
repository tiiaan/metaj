package com.tiiaan.tbm.metaj.interceptor;

import com.tiiaan.tbm.metaj.dto.UserDTO;
import com.tiiaan.tbm.metaj.holder.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Component
public class UserLoginInterceptor implements HandlerInterceptor {

    private StringRedisTemplate stringRedisTemplate;


    public UserLoginInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.从ThreadLocal获取用户
        UserDTO user = UserHolder.getUser();
        //2.如果有就放行，如果没有就拦截
        if (user == null) {
            response.setStatus(401);
            return false;
        }
        return true;
    }

}
