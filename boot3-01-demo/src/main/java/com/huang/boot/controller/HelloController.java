package com.huang.boot.controller;

import com.huang.boot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HYL
 * @Date 2023/6/21 10:04
 * @Version 1.0
 * @Description
 */
@RestController
public class HelloController {

    @Autowired
    private Person person;

    @GetMapping("/hello")
    public String hello() {

        return person.toString();
    }
}
