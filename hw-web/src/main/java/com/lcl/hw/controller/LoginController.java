package com.lcl.hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rain on 2016/12/30 14:05.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/toLogin")
    public String toLoginPage(){
        return "decorator/login";

    }
    @RequestMapping("/toRegister")
    public String toRegisterPage(){
        return "decorator/register";

    }
}
