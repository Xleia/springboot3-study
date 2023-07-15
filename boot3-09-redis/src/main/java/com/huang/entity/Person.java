package com.huang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;

/**
 * @Author HYL
 * @Date 2023/7/13
 * @Version 1.0
 * @Description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person implements Serializable {
    private Long id;
    private String name;
    private Integer age;
}
