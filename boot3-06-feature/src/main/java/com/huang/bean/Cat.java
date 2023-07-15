package com.huang.bean;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Author HYL
 * @Date 2023/6/21 16:27
 * @Version 1.0
 * @Description
 */

@Data
@Component
@Profile("dev") // 标识在哪个环境生效
public class Cat {
    private String name;
}
