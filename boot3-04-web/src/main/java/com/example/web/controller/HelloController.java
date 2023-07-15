package com.example.web.controller;

import com.example.web.bean.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HYL
 * @Date 2023/6/26
 * @Version 1.0
 * @Description
 */

@Slf4j
@RestController
public class HelloController {
    /**
     * 默认使用新版路径匹配器 PathPatternParser 进行路劲匹配
     * 不嫩匹配 ** 在中间的情况，剩下的和 antPathMatcher语法兼容
     *
     * @param request
     * @param path
     * @return
     */
    @GetMapping("/a*/b?/{p1:[a-f]+}/**")
    public String hello(HttpServletRequest request, @PathVariable("p1") String path) {
        log.info("路径变量p1：{}", path);
        // 获取请求路径
        String requestURI = request.getRequestURI();
        return requestURI;
    }

    /**
     * 默认返回的就是json类型
     * 2、jackson也支持把数据写为xml。但需要导入依赖
     * @return
     */
    @GetMapping("/person")
    public Person person() {
        Person person = new Person();
        person.setId(1L);
        person.setUserName("张三");
        person.setEmail("aaa.@qq.com");
        person.setAge(18);
        return person;
    }

    public static void aaa(String[] args) throws JsonProcessingException {
        Person person = new Person();
        person.setId(1L);
        person.setUserName("张三");
        person.setEmail("aaa.@qq.com");
        person.setAge(18);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        String s = mapper.writeValueAsString(person);
        System.out.println(s);
    }

}
