package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/12 - 17:44
 */
public interface IAccountService {
    List<Account> findAll();
}

