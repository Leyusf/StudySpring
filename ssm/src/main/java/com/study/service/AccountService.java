package com.study.service;

import com.study.domain.Account;

import java.util.List;

public interface AccountService {

    public void save(Account account);

    public List<Account> findAll();
}
