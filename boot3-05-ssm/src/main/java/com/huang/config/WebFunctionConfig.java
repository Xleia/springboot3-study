package com.huang.config;

import com.huang.biz.UserBizHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.*;

/**
 * @Author HYL
 * @Date 2023/7/9
 * @Version 1.0
 * @Description
 */

@Configuration
public class WebFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> userRouter(UserBizHandler userBizHandler){
        return RouterFunctions.route()
                .GET("/users", RequestPredicates.accept(MediaType.ALL),userBizHandler::getUsers)
                .build();
    }
}
