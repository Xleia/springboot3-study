package com.huang.config;

import com.huang.service.WeatherInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @Author HYL
 * @Date 2023/7/14
 * @Version 1.0
 * @Description
 */
@Configuration
public class APIConfiguration {

    @Bean
    HttpServiceProxyFactory httpServiceProxyFactory() {
        // 1、创建客户端
        WebClient client = WebClient.builder()
                .baseUrl("https://ali-weather.showapi.com")
                .build();

        // 2、创建工厂
        return HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client)).build();
    }


    @Bean
    WeatherInterface weatherInterface(HttpServiceProxyFactory httpServiceProxyFactory) {

        // 3、获取代理对象
        return httpServiceProxyFactory.createClient(WeatherInterface.class);
    }

}
