package com.huang.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @Author HYL
 * @Date 2023/7/14
 * @Version 1.0
 * @Description
 */

/**
 * 1、自定义请求授权规则：http.authorizeHttpRequests()
 * 2、自定义登录规则：http.formLogin()
 * 3、自定义用户信息查询规则：UserDetailsService
 * 4、开启方法级别的精确权限控制：@EnableMethodSecurity
 */

@EnableMethodSecurity
@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 请求授权
        http.authorizeHttpRequests(registry -> {
            registry.requestMatchers("/").permitAll() //首页所有人都可访问
                    .anyRequest().authenticated(); // 剩下的任意请求都需要认证
        });
        // 开启默认表单登录功能表单登录功能
        http.formLogin(formLogin -> {
            formLogin.loginPage("/login").permitAll(); // 自定义登录页位置，并且所有人都能访问
        });
        return http.build();
    }

    // 查询用户详细
    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails zhangsan = User.withUsername("zhangsan")
                .password(passwordEncoder.encode("123456"))
                .roles("admin")
                .authorities("file_reda", "file_write","world_exec")
                .build();
        UserDetails lisi = User.withUsername("lisi")
                .password(passwordEncoder.encode("123456"))
                .roles("hr")
                .authorities("file_reda")
                .build();

        // 默认内存保存所有用户信息
        return new InMemoryUserDetailsManager(zhangsan, lisi);
    }

    // 放一个密码加密器
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
