package com.example.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HYL
 * @Date 2023/6/21 11:09
 * @Version 1.0
 * @Description
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello,Spring Boot";
    }
}
