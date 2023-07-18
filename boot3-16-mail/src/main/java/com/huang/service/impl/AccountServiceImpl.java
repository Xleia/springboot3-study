package com.huang.service.impl;

import com.huang.emtity.Account;
import com.huang.repo.AccountRepository;
import com.huang.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author HYL
 * @Date 2023/7/17
 * @Version 1.0
 * @Description
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountRepository repository;

    @Override
    public void registerAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        account.setPassword(encoder.encode(password));
        repository.save(account);
    }
}
