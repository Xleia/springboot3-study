package com.huang.controller;

import com.huang.entity.UserEntity;
import com.huang.event.EventPublisher;
import com.huang.event.LoginSuccessEvent;
import com.huang.service.AccountService;
import com.huang.service.CouponService;
import com.huang.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HYL
 * @Date 2023/7/12
 * @Version 1.0
 * @Description
 */
@RestController
public class LoginController {

    @Autowired
    AccountService accountService;

    @Autowired
    CouponService couponService;

    @Autowired
    SysService sysService;

    @Autowired
    EventPublisher eventPublisher;

    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        // 业务处理登录
        System.out.println("业务处理登录。。。");

        // TODO 发布事件
        // 1、创建事件信息
        LoginSuccessEvent event = new LoginSuccessEvent(new UserEntity(username, password));
        // 2、发送事件
        eventPublisher.sendEvent(event);

        // 设计模式：对新增开放，对修改禁用

//        // 1、账户服务自动签到加积分
//        accountService.addAccountScore(username);
//        // 2、优惠服务随机发放优惠券
//        couponService.sendCoupon(username);
//        // 3、系统服务登记用户登录信息
//        sysService.recordLog(username);

        return username + "登录成功";
    }
}
