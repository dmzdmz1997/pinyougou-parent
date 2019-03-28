package com.itheima.service;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/16 - 18:48
 */
public interface IProductService {
    /**
     * 查询方法
     */
    List<Product> findAll();
    /**
     * 添加产品
     */
    void save(Product product);

    Product findById(Integer id);

    void update(Product product);
    void delete(String productIds);
    /**
     * 分页查询
     * @param pageNum 当前页
     * @param pageSize 页大小
     * @return 通过PageBean封装分页参数并返回
     */
    PageBean<Product> findByPage(int pageNum, int pageSize);
}
