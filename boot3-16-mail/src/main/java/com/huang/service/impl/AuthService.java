package com.huang.service.impl;

import com.huang.emtity.Account;
import com.huang.repo.AccountRepository;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author HYL
 * @Date 2023/7/17
 * @Version 1.0
 * @Description
 */
@Service
public class AuthService implements UserDetailsService {

    @Resource
    AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Account account = repository.findAccountByUsername(username);
        // 如果找不到返回异常
        if (account == null) throw new UsernameNotFoundException("");
        return User.withUsername(account.getUsername())
                .password(account.getPassword())
                .roles("user")
                .build();
    }
}
