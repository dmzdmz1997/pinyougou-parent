package com.itheima.b_requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 朱惠
 * @date 2019/3/9 - 19:19
 */
@Controller
@RequestMapping(path = "/perrson")
public class RequestMappingController {
    @RequestMapping(value = "/value.do",method = RequestMethod.GET,params =
            {"id = 100"})
    public String save(){
        return "success";
    }
}
