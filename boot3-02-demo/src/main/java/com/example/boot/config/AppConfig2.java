package com.example.boot.config;

import com.example.boot.entity.Cat;
import com.example.boot.entity.Dog;
import com.example.boot.entity.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;

/**
 * @Author HYL
 * @Date 2023/6/21 16:26
 * @Version 1.0
 * @Description
 */
@SpringBootConfiguration
public class AppConfig2 {

    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
    @Bean
    public Cat cat01() {
        return new Cat();
    }

    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog01() {
        return new Dog();
    }

    @ConditionalOnBean(name = "dog01")
    @Bean
    public User zhangsan() {
        return new User();
    }

    @ConditionalOnMissingBean(name = "dog01")
    @Bean
    public User lisi() {
        return new User();
    }
}
