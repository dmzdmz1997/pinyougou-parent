package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/16 - 20:28
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("findAll")
    public ModelAndView findAll(){
        List<Order> list = orderService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("order-list");
        return  mv;
    }
    @RequestMapping("findByPage")
    public ModelAndView findByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "2") int pageSize){
        //1.1 查询产品
        PageInfo<Order> pageInfo = orderService.findByPaage(pageNum, pageSize);
        //1.2 返回结果
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo ",pageInfo);
        mv.setViewName("order-list");
        return mv;
    }
}
