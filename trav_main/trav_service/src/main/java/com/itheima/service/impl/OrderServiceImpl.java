package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.IOrderDao;
import com.itheima.domain.Order;
import com.itheima.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/16 - 20:25
 */
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public PageInfo<Order> findByPaage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> list = orderDao.findAll();
        return new PageInfo<Order>(list);
    }
}
