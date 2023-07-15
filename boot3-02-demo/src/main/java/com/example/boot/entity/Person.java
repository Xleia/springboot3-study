package com.example.boot.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author HYL
 * @Date 2023/6/22 21:35
 * @Version 1.0
 * @Description
 */

@Component
@ConfigurationProperties(prefix = "person")  // 和配置文件中所有以person前缀进行绑定
@Data  // 自动生成JavaBean属性的getter/setter
public class Person {
    private String name;
    private Integer age;
    private Date birthday;
    private Boolean like;
    private Child child;
    private List<Dog> dogs;
    private Map<String, Cat> cats;
}
