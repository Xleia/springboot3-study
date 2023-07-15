package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HYL
 * @Date 2023/6/28
 * @Version 1.0
 * @Description
 */
//@RestController // 一般适配前后端分离
@Controller // 适配 服务端渲染
public class WelcomeController {

    /**
     * 利用模板引擎跳转到页面
     *
     * @return
     */
    @GetMapping("/welcome")
    public String hello(@RequestParam("name") String name, Model model) {

        // 把需要给页面共享的数据放到model中
        model.addAttribute("msg", name);

        // 模板的逻辑试图
        // 物理试图 = 前缀 + 逻辑试图名 + 后缀
        // 真实地址 = classpath:/templates/welcome.html
        return "welcome";
    }
}
