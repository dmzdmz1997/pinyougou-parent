package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Order;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/16 - 20:22
 */
public interface IOrderService {
    List<Order> findAll();

    /**
     * 分页查询
     * @param pageNum 当前页
     * @param pageSize 页大小
     * @return
     */
    PageInfo<Order> findByPaage(int pageNum,int pageSize);
}
