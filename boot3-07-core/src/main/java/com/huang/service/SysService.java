package com.huang.service;

import com.huang.entity.UserEntity;
import com.huang.event.LoginSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @Author HYL
 * @Date 2023/7/12
 * @Version 1.0
 * @Description
 */

@Service
public class SysService {

    public void recordLog(String username) {
        System.out.println(username + "登录了");
    }

    @EventListener
    public void onEvent(LoginSuccessEvent loginSuccessEvent) {
        UserEntity source = (UserEntity) loginSuccessEvent.getSource();
        recordLog(source.getUsername());
    }
}
