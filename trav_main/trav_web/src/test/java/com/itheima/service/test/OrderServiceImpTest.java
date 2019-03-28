package com.itheima.service.test;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Order;
import com.itheima.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 朱惠
 * @date 2019/3/19 - 18:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OrderServiceImpTest {
    @Autowired
    private IOrderService orderService;
    @Test
    public void  find(){
        PageInfo<Order> pageInfo = orderService.findByPaage(1,10);
        System.out.println(pageInfo);
    }
}
