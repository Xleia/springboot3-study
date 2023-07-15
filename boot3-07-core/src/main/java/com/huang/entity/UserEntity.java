package com.huang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author HYL
 * @Date 2023/7/12
 * @Version 1.0
 * @Description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    private String username;
    private String password;

}
