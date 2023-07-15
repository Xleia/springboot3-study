package com.huang.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYL
 * @Date 2023/7/13
 * @Version 1.0
 * @Description
 */
@Service
public class WeatherService {

    public Mono<String> weather(String city) {

        // 远程调用aliyun的API

//        Mono<String> mono = getByWebClient(city);
        Mono<String> mono = getByHttpInterface(city);

        return mono;
    }

    private static Mono<String> getByHttpInterface(String city) {
        // 1、创建客户端
        WebClient client = WebClient.builder()
                .baseUrl("https://ali-weather.showapi.com")
                .build();

        // 2、创建工厂
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client)).build();
        // 3、获取代理对象
        WeatherInterface weatherAPI = factory.createClient(WeatherInterface.class);


        return weatherAPI.getWeather(city, "APPCODE 955e02545445408b86a7c64c5592fb90");
    }

    private static Mono<String> getByWebClient(String city) {
        //1、创建webClient
        WebClient webClient = WebClient.create();

        Map<String, String> params = new HashMap<>();
        params.put("city", city);
        //2、定义发请求行为
        return webClient.get()
                .uri("https://ali-weather.showapi.com/area-to-weather-date?area={city}", params)
                .accept(MediaType.APPLICATION_JSON)// 定义响应的内容类型
                .header("Authorization", "APPCODE 955e02545445408b86a7c64c5592fb90")
                .retrieve()
                .bodyToMono(String.class);
    }

}
