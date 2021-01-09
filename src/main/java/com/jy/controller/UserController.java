package com.jy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试接口
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-01-09 11:23
 */
@Controller
public class UserController {

    @ResponseBody
    @GetMapping("/index")
    public String getUserInfo(){
        System.out.println("=====请求进来了===");
        return "hello tom";
    }

    @ResponseBody
    @GetMapping("/index1")
    public Map<String,Object> test() {
        System.out.println("=====map ===");
        Map<String,Object> map = new HashMap<>();
        map.put("name","tom");
        map.put("age",123);
        return map;
    }
}
