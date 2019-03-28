package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/13 - 19:14
 */
public interface  IAccountDao {
    @Select("select * from account")
    List<Account> findAll();
}
