package com.itheima.a_model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 朱惠
 * @date 2019/3/10 - 15:58
 */
@Controller
public class UserContoller {
    @RequestMapping("save")
    public String save(Model model){
        model.addAttribute("on","China");
        return "success";
    }
    public String update(ModelMap model){
        model.addAttribute("usa","America");
        return "success";
    }
}
