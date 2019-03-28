package com.itheima.c_request_param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 朱惠
 * @date 2019/3/9 - 20:02
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/save")
    public String ssave(Integer id ,String name){
        System.out.println(id + "," +name);
        return "success";
    }
}
