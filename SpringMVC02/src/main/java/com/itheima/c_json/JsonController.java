package com.itheima.c_json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 朱惠
 * @date 2019/3/10 - 20:00
 */
@Controller
public class JsonController {
    @RequestMapping("responseBodyJson")
    @ResponseBody
    public Account save(@RequestBody Account account){
        System.out.println("传入方法的参数：" + account);
        account.setId(168);
        account.setName("Qiuqiu");
        account.setMoney(1);
        return account;
    }
}
