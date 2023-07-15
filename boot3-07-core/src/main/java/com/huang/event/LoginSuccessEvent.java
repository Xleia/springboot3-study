package com.huang.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @Author HYL
 * @Date 2023/7/12
 * @Version 1.0
 * @Description 登录成功事件
 */
public class LoginSuccessEvent extends ApplicationEvent {

    /**
     * @param source 代表谁登录成功
     */
    public LoginSuccessEvent(Object source) {
        super(source);
    }
}
