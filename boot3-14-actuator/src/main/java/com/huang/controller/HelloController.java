package com.huang.controller;

import com.huang.component.MyComponent;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    MyComponent myComponent;

    @GetMapping("/hello")
    public String hello() {
        // 业务调用
        myComponent.hello();
        return "hello";
    }

}
