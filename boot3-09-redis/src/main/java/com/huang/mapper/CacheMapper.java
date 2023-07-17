package com.huang.mapper;

import com.huang.cache.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author HYL
 * @Date 2023/7/16
 * @Version 1.0
 * @Description
 */
@CacheNamespace(implementation = MybatisRedisCache.class)
@Mapper
public interface CacheMapper {
    @Select("select username from db1.user where password=222222")
    String getSid();
}
