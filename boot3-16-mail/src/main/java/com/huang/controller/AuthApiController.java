package com.huang.controller;

import com.huang.emtity.resp.ResponseResult;
import com.huang.service.AccountService;
import com.huang.service.VerifyService;
import com.huang.service.impl.AuthService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HYL
 * @Date 2023/7/17
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/api/auth")
public class AuthApiController {

    @Resource
    VerifyService verifyService;

    @Resource
    AccountService accountService;

    @Resource
    AuthService authService;

    @RequestMapping(value = "/verify-code", method = RequestMethod.GET)
    public ResponseResult<Void>  verifyCode(@RequestParam("email") String email) {
        verifyService.sendVerifyCode(email);
        return  new ResponseResult<>(200, "邮件已发送");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseResult<Void> register(String username,
                                         String password,
                                         String email,
                                         String verifyCode) {
        if (verifyService.doVerify(email, verifyCode)) {
            accountService.registerAccount(username, password);
            System.out.println("注册成功");
            return new ResponseResult<>(200, "注册成功");
        } else {
            System.out.println("注册失败");
            return new ResponseResult<>(403, "注册失败");
        }
    }

    @RequestMapping(value = "/login-success", method = RequestMethod.POST)
    public ResponseResult<Void> loginSuccess() {
        return new ResponseResult<>(200,"登陆成功");
    }

    @RequestMapping(value = "/login-failure", method = RequestMethod.POST)
    public ResponseResult<Void> loginFailure() {
        return new ResponseResult<>(304,"登陆失败");
    }
}
