package com.huang.boot;

import com.huang.boot.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author HYL
 * @Date 2023/6/21 9:58
 * @Version 1.0
 * @Description 启动spring boot项目的主入口程序
 */

@SpringBootApplication()
public class MainApplication {

    public static void main(String[] args) {
        // java10：局部变量类型的自动推断
        var ioc = SpringApplication.run(MainApplication.class, args);

        // 1、获取容器中所有组件的名字
        String[] names = ioc.getBeanDefinitionNames();
        // spring boot把以前配置的核心组件现在都配置好了
        for (String name : names) {
            System.out.println(name);
        }

        Person bean = ioc.getBean(Person.class);
        System.out.println("person: " + bean);
    }
}
