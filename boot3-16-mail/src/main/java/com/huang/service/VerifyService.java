package com.huang.service;

/**
 * @Author HYL
 * @Date 2023/7/17
 * @Version 1.0
 * @Description
 */

public interface VerifyService {

    public void sendVerifyCode(String email);

    boolean doVerify(String email,String code);
}
