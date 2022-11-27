package com.tiiaan.tbm.metaj.config;

import com.tiiaan.tbm.metaj.interceptor.InstanceUploadInterceptor;
import com.tiiaan.tbm.metaj.interceptor.UserLoginInterceptor;
import com.tiiaan.tbm.metaj.interceptor.UserTokenRefreshInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InstanceUploadInterceptor(stringRedisTemplate))
                .addPathPatterns("/monitor/upload");
        registry.addInterceptor(new UserTokenRefreshInterceptor(stringRedisTemplate))
                .excludePathPatterns("/monitor/upload")
                .order(0);
        registry.addInterceptor(new UserLoginInterceptor())
                .excludePathPatterns("/monitor/upload")
                .excludePathPatterns("/user/login")
                .order(1);
    }
}
