package com.huang.service;

import com.huang.entity.UserEntity;
import com.huang.event.LoginSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @Author HYL
 * @Date 2023/7/12
 * @Version 1.0
 * @Description
 */
@Service
public class AccountService implements ApplicationListener<LoginSuccessEvent> {

    public void addAccountScore(String username) {
        System.out.println(username + "加了一分");
    }

        // 方式一：
        @Override
        public void onApplicationEvent(LoginSuccessEvent event) {
            System.out.println("AccountService 收到事件");
            UserEntity source = (UserEntity) event.getSource();
            addAccountScore(source.getUsername());
        }

}
