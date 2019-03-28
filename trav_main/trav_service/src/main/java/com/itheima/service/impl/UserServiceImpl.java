package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.SysUser;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// 注意：加入容器的service的名称一定要与spring-security.xml引用的名称一致
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    // 通过方法返回的UserDetails对象，告诉springsecurity数据库正确的账号密码，以及用户具有的权限。
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1. 根据用户名查询用户
        List<SysUser> list = userDao.findByUsername(username);

        //2. 判断
        if (list == null || list.size() == 0) {
            // 说明用户名不存在
            return null;
        }

        // 获取用户
        SysUser sysUser = list.get(0);

        // 用户具有的角色（角色就是权限的集合）
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        //3. 返回UserDetails类型的对象
        // 参数1：数据库中正确的用户名
        // 参数2：数据库中正确的密码
        // 参数3：用户的角色
        UserDetails userDetails = new User(username,"{noop}"+sysUser.getPassword(),authorities);
        return userDetails;
    }
}
