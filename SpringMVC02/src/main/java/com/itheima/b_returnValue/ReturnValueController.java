package com.itheima.b_returnValue;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 朱惠
 * @date 2019/3/10 - 16:39
 */
public class ReturnValueController {
    /**
     * 控制器方法返回值：
     * 1. 返回String
     *    1.1 返回普通字符串
     */
    @RequestMapping
    public String reStrring(){
        return "success";
    }

    /**
     *  控制器方法返回值：
     * @return
     */
    @RequestMapping("forward")
    public String forward(){
        return "forward:/index.html";
    }
    @RequestMapping("redirect")
    public String redirect(){
        return "redirect:/index.html";
    }
    public void retVoid(HttpServletResponse response) throws IOException {
    response.sendRedirect("/index.html");
    }
    public ModelAndView mv(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("cn","China");
        mv.addObject("usa","America");
        mv.setViewName("success");
        return mv;
    }

}
