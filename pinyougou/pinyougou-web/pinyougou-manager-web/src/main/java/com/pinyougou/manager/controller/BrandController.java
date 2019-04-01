package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.Brand;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌控制器
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2019-03-26<p>
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    /**
     * 引用服务
     * timeout:调用服务超时(1000毫秒)
     * */
    @Reference(timeout = 10000)
    private BrandService brandService;

    /** 查询全部品牌 */
    @GetMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }
    /**
     * 添加品牌方法
     */
    @RequestMapping("/save")
    public boolean save(@RequestBody Brand brand){
        try {
            brandService.save(brand);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/update")
    public boolean update(@RequestBody Brand brand){
        try {
            brandService.update(brand);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestBody Long[] ids){
        try {
            brandService.deleteAll(ids);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    /**
     * 分页查询品牌
     */
   /* @GetMapping("/findByPage")
    public PageResult findByPage(Integer page, Integer rows){
        return brandService.findByPage(null,page,rows);
    }*/
    /**
     * 多条件分页查询
     */
    /** 多条件分页查询品牌 */
    @GetMapping("/findByPage")
    public PageResult findByPage(Brand brand, Integer page, Integer rows){
        /** GET请求中文转码 */
        if (brand != null && StringUtils.isNoneBlank(brand.getName())) {
            try {
                brand.setName(new String(brand.getName()
                        .getBytes("ISO8859-1"), "UTF-8"));
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return brandService.findByPage(brand, page, rows);
    }

}
