package com.huang.emtity.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author HYL
 * @Date 2023/7/17
 * @Version 1.0
 * @Description
 */
@Data
@AllArgsConstructor
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
