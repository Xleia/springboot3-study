package com.huang.controller;

import com.huang.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author HYL
 * @Date 2023/7/13
 * @Version 1.0
 * @Description
 */

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    public Mono<String> weather(@RequestParam("city") String city){
        // 查询天气
        return weatherService.weather(city);
    }
}
