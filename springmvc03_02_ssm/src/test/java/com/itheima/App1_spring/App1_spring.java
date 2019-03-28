package com.itheima.App1_spring;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/13 - 15:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class App1_spring {
    //注入service:根据类型去容器对象注入
    @Autowired
    private IAccountService accountService;

    @Test
    public void  findAll(){
        List<Account> list = accountService.findAll();
        System.out.println(list);
    }
}
