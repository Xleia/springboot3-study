package com.huang.config;

import com.huang.service.impl.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @Author HYL
 * @Date 2023/7/17
 * @Version 1.0
 * @Description
 */
@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(registry ->
                registry
                        .requestMatchers("/login.html", "register.html", "/api/auth/**", "/static/**").permitAll()
                        .anyRequest().authenticated()
        );
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/api/auth/login")
                .successForwardUrl("/api/auth/login-success")
                .failureForwardUrl("/api/auth/login-failure");

        http.logout()
                .logoutUrl("/api/auth/logout")
                .logoutSuccessUrl("/login.html");

        http.csrf().disable();
        return http.build();
    }

    //这里用于登录
    @Bean
    UserDetailsService userDetailsService() {
        return new AuthService();
    }
}
