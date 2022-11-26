package com.tiiaan.tbm.metaj.interceptor;

import com.tiiaan.tbm.metaj.holder.InstanceHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.tiiaan.tbm.metaj.common.RedisConstants.*;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Component
public class InstanceUploadInterceptor implements HandlerInterceptor {

    private StringRedisTemplate stringRedisTemplate;

    public InstanceUploadInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null || token.length() == 0) {
            return false;
        }
        String key = INSTANCE_TOKEN + token;
        String idStr = stringRedisTemplate.opsForValue().get(key);
        if (idStr == null || idStr.length() == 0) {
            return false;
        }
        InstanceHolder.saveInstanceId(Long.valueOf(idStr));
        return true;
    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        InstanceHolder.removeInstanceId();
    }

}
