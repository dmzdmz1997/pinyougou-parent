package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 服务接口实现类
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2019-03-26<p>
 */
@Service(interfaceName = "com.pinyougou.service.BrandService")
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
    @Override
    public void save(Brand brand){
        brandMapper.insertSelective(brand);
    }
    @Override
    public void update(Brand brand){
        brandMapper.updateByPrimaryKeySelective(brand);
    }
    public void deleteAll(Serializable[] ids){
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id" , Arrays.asList(ids));
        brandMapper.deleteByExample(example);
    }

/*    public PageResult findByPage(Brand brand, int page , int rows){
        PageInfo<Brand> pageInfo = PageHelper.startPage(page,rows).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                brandMapper.selectAll();
            }
        });
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }*/

@Override
public PageResult findByPage(Brand brand, int page, int rows) {
    try {
        // 开始分页
        PageInfo<Brand> pageInfo = PageHelper.startPage(page, rows)
                .doSelectPageInfo(new ISelect() {
                    @Override
                    public void doSelect() {
                        brandMapper.findAll(brand);
                    }
                });
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }catch (Exception ex){
        throw new RuntimeException(ex);
    }
}


}
