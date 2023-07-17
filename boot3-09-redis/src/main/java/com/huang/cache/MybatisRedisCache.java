package com.huang.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author HYL
 * @Date 2023/7/16
 * @Version 1.0
 * @Description
 */
// 实现Mybatis的Cache接口
public class MybatisRedisCache implements Cache {

    private final String id;
    private static RedisTemplate<Object, Object> template;

    //构造方法必须带一个String类型的参数接收id
    public MybatisRedisCache(String id) {
        this.id = id;
    }

    //初始化时通过配置类将RedisTemplate给过来
    public static void setTemplate(RedisTemplate<Object, Object> template) {
        MybatisRedisCache.template = template;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        //这里直接向Redis数据库中丢数据，第一个参数为key，第二个为value
        template.opsForValue().set(key, value, 60, TimeUnit.SECONDS);
    }

    @Override
    public Object getObject(Object key) {
        //根据key直接从redis数据库中获取值
        return template.opsForValue().get(key);
    }

    @Override
    public Object removeObject(Object key) {
        //根据key删除value
        return template.delete(key);
    }

    @Override
    public void clear() {
        //由于template中没有封装清除操作，之呢个通过connection来执行
        template.execute((RedisCallback<Void>) connection -> {
            connection.serverCommands();
            return null;
        });
    }

    @Override
    public int getSize() {
        //这里也是用connection对象来获取当前key的数量
        return template.execute(RedisServerCommands::dbSize).intValue();
    }
}
