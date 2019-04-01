package com.pinyougou.service;

import com.pinyougou.pojo.Brand;
import com.pinyougou.pojo.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * 品牌服务接口
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2019-03-26<p>
 */
public interface BrandService {

    /** 查询全部品牌 */
    List<Brand> findAll();

    public void save(Brand brand);

    public void update(Brand brand);

    PageResult findByPage(Brand brand,int page , int rows);

    public void deleteAll(Serializable[] ids);
}
