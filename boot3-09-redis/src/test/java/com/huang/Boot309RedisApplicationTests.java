package com.huang;

import com.huang.mapper.CacheMapper;
import com.huang.service.RedisService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;

@SpringBootTest
class Boot309RedisApplicationTests {

    @Resource
    RedisService redisService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * String：  普通字符串
     */
    @Test
    void testString() {

        stringRedisTemplate.opsForValue().set("haha", UUID.randomUUID().toString());

        String haha = stringRedisTemplate.opsForValue().get("haha");
        System.out.println(haha);
    }

    /**
     * list：    列表
     */
    @Test
    void testList() {
        String listName = "listTest";
        stringRedisTemplate.opsForList().leftPush(listName, "1");
        stringRedisTemplate.opsForList().leftPush(listName, "2");
        stringRedisTemplate.opsForList().leftPush(listName, "3");

        String pop = stringRedisTemplate.opsForList().leftPop(listName);
        Assertions.assertEquals("3", pop);
    }

    /**
     * set：     集合（无序）
     */
    @Test
    void testSet() {
        String setName = "setTest";
        // 集合中添加元素
        stringRedisTemplate.opsForSet().add(setName, "1", "2", "3", "3");
        // 判断集合中是否有此元素
        Boolean member1 = stringRedisTemplate.opsForSet().isMember(setName, "2");
        Assertions.assertEquals(true, member1);

        Boolean member2 = stringRedisTemplate.opsForSet().isMember(setName, "5");
        Assertions.assertEquals(false, member2);
    }

    @Test
    void testTransaction() {
        redisService.test();
    }

    @Test
    void testTransaction2() {
        System.out.println(stringRedisTemplate.opsForValue().get("d"));
    }

    @Resource
    CacheMapper cacheMapper;

    @Test
    void cacheTest(){
        cacheMapper.getSid();
    }


}
