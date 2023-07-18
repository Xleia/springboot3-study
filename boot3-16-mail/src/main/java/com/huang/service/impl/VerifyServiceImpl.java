package com.huang.service.impl;

import com.huang.service.VerifyService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author HYL
 * @Date 2023/7/17
 * @Version 1.0
 * @Description
 */
@Service
public class VerifyServiceImpl implements VerifyService {

    @Resource
    JavaMailSender sender;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Value("${spring.mail.username}")
    String from;

    @Override
    public void sendVerifyCode(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("【xxx网站】你的注册验证码");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            stringBuilder.append(random.nextInt(10));
        }
        String code = String.valueOf(stringBuilder);
        stringRedisTemplate.opsForValue().set("verify.code:" + email, code, 3, TimeUnit.MINUTES);
        message.setText("您的注册验证码为：" + code + "，三分钟内有效，请及时完成注册，如果不是本人，请忽略。");
        message.setTo(email);
        message.setFrom(from);
        sender.send(message);
    }

    @Override
    public boolean doVerify(String email, String code) {
        String s = stringRedisTemplate.opsForValue().get("verify.code:" + email);
        if (s == null || !s.equalsIgnoreCase(code)) return false;
        stringRedisTemplate.delete("verify.code:" + email);
        return true;
    }
}
