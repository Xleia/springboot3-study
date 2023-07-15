package com.example.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author HYL
 * @Date 2023/7/8
 * @Version 1.0
 * @Description
 */
@Configuration
@EnableWebMvc  // 禁用mvc默认功能
public class WebConfig implements WebMvcConfigurer {

}
