package com.itheima.dao;

import com.itheima.domain.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/20 - 19:11
 */
public interface IUserDao {
    /**
     * 根据用户名查询
     */
    @Select("select * from sys_user where username=#{username}")
    List<SysUser> findByUsername(String username);
}
