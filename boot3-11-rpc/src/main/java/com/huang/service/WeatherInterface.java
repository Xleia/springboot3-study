package com.huang.service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

/**
 * @Author HYL
 * @Date 2023/7/14
 * @Version 1.0
 * @Description
 */
public interface WeatherInterface {

    @GetExchange(url = "/area-to-weather-date", accept = "application/json")
    Mono<String> getWeather(@RequestParam("area") String city,
                    @RequestHeader("Authorization") String header);

}
