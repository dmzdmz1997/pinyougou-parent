package com.itheima.controller;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/16 - 19:24
 */
@Controller
@RequestMapping("product")
public class ProductControllerr {
    @Autowired
    private IProductService productService;
    @RequestMapping("findAll")
    public ModelAndView findAll(){
        List<Product> list = productService.findAll();
        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        view.setViewName("product-list");
        return view;
    }
    @RequestMapping("findByPage")
    public ModelAndView findByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "2") int pageSize){
        //1.1 查询产品
        PageBean<Product> pb = productService.findByPage(pageNum,pageSize);
        //1.2 返回结果
        ModelAndView mv = new ModelAndView();
        mv.addObject("pb",pb);
        mv.setViewName("product-list");
        return mv;
    }
    /**
     * 2. 添加产品，添加后重定向到列表
     */
    @RequestMapping("save")
    public String save(Product product){
        productService.save(product);
        return "redirect:/product/findAll";
    }
    /**
     * 3. 主键查询
     */
    @RequestMapping("findById")
    public ModelAndView findById(Integer id){
        // 查询产品
        Product product = productService.findById(id);
        // 返回
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product-update");
        mv.addObject("product",product);
        return mv;
    }
    /**
     * 4. 修改
     */
    @RequestMapping("update")
    public String update(Product product){
        productService.update(product);
        return "redirect:/product/findAll";
    }
    /**
     * 5. 修改
     * 参数： 传入的多个产品id，用逗号隔开。
     */
    @RequestMapping("delete")
    public String delete(String productIds){
        productService.delete(productIds);
        return "redirect:/product/findAll";
    }
}
