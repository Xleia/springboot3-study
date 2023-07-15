package com.huang.controller;

import com.huang.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HYL
 * @Date 2023/7/13
 * @Version 1.0
 * @Description
 */

@RestController
public class RedisTestController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 如果使用 RedisTemplate<Object, Object>给redis中保存数据会使用默认的序列化机制，导致redis中保存的对象不可视
     * 为了后来系统的兼容性，将所有的对象都以json的格式保存
     */
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("/count")
    public String count() {
        Long hello = stringRedisTemplate.opsForValue().increment("hello");

        // redis所有的数据都是 k:v 键值对形式，key唯一，value可以有多种数据类型（如下）
        // 常见的多种数据类型有：
        // String：  普通字符串
        // list：    列表
        // set：     集合（无序）
        // zset：    集合（有序）
        // hash：    哈希值

        return "访问了【" + hello + "】";
    }

    @GetMapping("/person/save")
    public String savePerson() {
        Person person = new Person(1L, "张三", 18);

        // 1、序列化，将person装换为字符串方式
        redisTemplate.opsForValue().set("person", person);

        return "ok";
    }

    @GetMapping("/person/get")
    public Person getPerson() {
        return (Person) redisTemplate.opsForValue().get("person");
    }
}
