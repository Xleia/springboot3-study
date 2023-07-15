package com.example.boot.config;

import com.alibaba.druid.FastsqlException;
import com.example.boot.entity.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * @Author HYL
 * @Date 2023/6/21 15:50
 * @Version 1.0
 * @Description
 */

//@Configuration
@SpringBootConfiguration
@Import(FastsqlException.class)
public class AppConfig {

    @Bean("userHhh")
    @Scope("prototype")  // 配置此为多实例的
    public User user111() {
        User user = new User();
        user.setId(1L);
        user.setName("li4");
        return user;
    }

//    @Bean
//    public FastsqlException fastsqlException() {
//        return new FastsqlException();
//    }
}
