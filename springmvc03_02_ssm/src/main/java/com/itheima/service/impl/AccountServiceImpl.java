package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/12 - 20:51
 */
@Service
public class AccountServiceImpl  implements IAccountService {

    @Autowired
    private IAccountDao accountDao;
    @Autowired
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
