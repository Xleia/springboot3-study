package com.huang.entity;

import lombok.Data;

/**
 * @Author HYL
 * @Date 2023/7/9
 * @Version 1.0
 * @Description
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String nickName;
}
