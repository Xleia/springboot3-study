package com.example.web.config;

import com.example.web.biz.UserBizHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @Author HYL
 * @Date 2023/7/9
 * @Version 1.0
 * @Description
 */

@Configuration
public class WebFunctionConfig {

    /**
     * 函数式web步骤
     * 1、给容器中放入一个Bean
     * 2、每个业务准备一个自己的handler
     *
     *
     * 核心四大对象：
     * 1、RouterFunction：定义路由信息。发什么请求之类的
     * 2、RequestPredicate：定义请求规则
     * 3、ServerRequest：封装请求完整数据
     * 4、ServerResponse：封装响应完整数据
     */

    @Bean
    public RouterFunction<ServerResponse> userRouter(UserBizHandler userBizHandler) {
        return RouterFunctions.route()// 开始定义路由信息
                .GET("/user/{id}", RequestPredicates.accept(MediaType.ALL), userBizHandler::getUser)
                .build();
    }
}
