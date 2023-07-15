package com.huang.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HYL
 * @Date 2023/7/14
 * @Version 1.0
 * @Description
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Security";
    }

    @PreAuthorize("hasAuthority('world_exec')")
    @GetMapping("/world")
    public String world(){
        return "World Security";
    }
}
