package com.huang;

import com.huang.emtity.Account;
import com.huang.repo.AccountRepository;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.util.Random;

@SpringBootTest
class Boot316MailApplicationTests {

    //JavaMailSender是专门用于发送邮件的对象
    @Autowired
    JavaMailSender sender;

    @Test
    void contextLoads() {
        //SimpleMailMessage是一个简易的邮件封装
        SimpleMailMessage message = new SimpleMailMessage();
        //设置邮件标题
        message.setSubject("邮件标题");
        //设置邮件内容
        message.setText("邮件内容");
        //设置邮件发送给谁
        message.setTo("1575863127@qq.com");
        //设置发送者
        message.setFrom("huangyilei2001@163.com");
        //发送
        sender.send(message);
    }

    @Test
    void contextLoads1() throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        //设置邮件标题
        messageHelper.setSubject("邮件标题");
        //设置邮件内容
        messageHelper.setText("邮件内容");
        //设置邮件发送给谁
        messageHelper.setTo("1575863127@qq.com");
        //设置发送者
        messageHelper.setFrom("huangyilei2001@163.com");
        //发送
        sender.send(message);
    }

    @Test
    void context() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            code.append(random.nextInt(10));
        }
        System.out.println(code);
    }

    @Resource
    AccountRepository repository;

    @Test
    void repositoryTest() {
        repository.findById(1).ifPresent(System.out::println);
//        Account account = new Account();
//        account.setUsername("admin");
//        account.setPassword("123456");
//        account = repository.save(account);
//        System.out.println(account.getId());
//        repository.deleteById(5);
//        repository.findAll(PageRequest.of(1,2)).forEach(System.out::println);
//        Account lisi = repository.findAccountByUsername("lisi");
//        System.out.println(lisi);
    }

}
