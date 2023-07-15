package com.huang.boot.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author HYL
 * @Date 2023/6/22 21:37
 * @Version 1.0
 * @Description
 */
@Data
public class Child {
    private String name;
    private Integer age;
    private Date birthday;
    private List<String> text;  // 集合类型的
}
