package com.itheima.contoller;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/13 - 16:12
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    private IAccountService accountService;
    /**
     * 查询全部
     */
    @RequestMapping("findAll")
    public ModelAndView findAll(){
        List<Account> list = accountService.findAll();
        ModelAndView andView = new ModelAndView();

        andView.setViewName("list");
        andView.addObject("list",list);
        return andView;
    }
}
