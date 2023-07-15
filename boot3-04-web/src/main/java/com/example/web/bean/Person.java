package com.example.web.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @Author HYL
 * @Date 2023/6/26
 * @Version 1.0
 * @Description
 */
@Data
@JacksonXmlRootElement
public class Person {
    private Long id;
    private String userName;
    private String email;
    private Integer age;
}
