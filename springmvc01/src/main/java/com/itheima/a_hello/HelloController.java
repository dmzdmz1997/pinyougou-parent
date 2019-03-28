package com.itheima.a_hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 朱惠
 * @date 2019/3/9 - 16:10
 */
@Controller
public class HelloController {
    /**
     * 处理请求的方法
     */
    @RequestMapping("/hello.do")
    public String hello(){
        System.out.println();
        System.out.println();
        System.out.println();
        return "success";
    }
}
