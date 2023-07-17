package com.huang.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author HYL
 * @Date 2023/7/16
 * @Version 1.0
 * @Description
 */
@Service
public class RedisService {

    @Resource
    StringRedisTemplate template;

    @PostConstruct
    public void init() {
        template.setEnableTransactionSupport(true);  // 需要开启事务
    }

    @Transactional
    public void test() {
        template.multi();
        template.opsForValue().set("d", "xxxxx");
        template.exec();
    }
}
