package com.example.web.config;

import com.example.web.component.MyYamlHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author HYL
 * @Date 2023/6/26
 * @Version 1.0
 * @Description
 */

//@EnableWebMvc
//@Configuration // 告诉spring这是一个配置类
@Configuration
public class MyConfig /*implements WebMvcConfigurer*/ {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                WebMvcConfigurer.super.addResourceHandlers(registry);
                // 自己额外添加
                registry.addResourceHandler("/static/**")
                        .addResourceLocations("classpath:/a/", "classpath:/b/")
                        .setCacheControl(CacheControl.maxAge(7200, TimeUnit.SECONDS));
            }

            @Override  // 配置一个把对象转为yaml的messageConverter
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new MyYamlHttpMessageConverter());
            }
        };
    }


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 保留以前的配置
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//
//        // 自己额外添加
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/a/", "classpath:/b/")
//                .setCacheControl(CacheControl.maxAge(7200, TimeUnit.SECONDS));
//    }
}
