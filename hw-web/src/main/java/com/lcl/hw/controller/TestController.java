package com.lcl.hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rain on 2016/12/14 17:18.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("main")
    public String helloWorld(){
        System.out.println("helleWorld!");
        return "index";
    }
}
