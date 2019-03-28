package com.itheima.App1_spring;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/13 - 19:55
 */
public class Test_2_mybatis {
    @Test
    public void testMybatis() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        session.commit();
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        List<Account> list = accountDao.findAll();
        System.out.println(list);
        session.close();
    }
}
