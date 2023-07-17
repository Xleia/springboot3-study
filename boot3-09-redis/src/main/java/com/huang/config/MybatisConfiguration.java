package com.huang.config;

import com.huang.cache.MybatisRedisCache;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author HYL
 * @Date 2023/7/16
 * @Version 1.0
 * @Description
 */
@Configuration
public class MybatisConfiguration {

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @PostConstruct
    public void init() {
        MybatisRedisCache.setTemplate(redisTemplate);
    }
}
