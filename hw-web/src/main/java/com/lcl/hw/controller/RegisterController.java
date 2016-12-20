package com.lcl.hw.controller;

import com.lcl.hw.domain.Register;
import com.lcl.hw.services.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Rain on 2016/12/15 8:36.
 */
@Controller
@RequestMapping("register")
public class RegisterController {
    Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Resource
    private TestService testService;

    @RequestMapping("test")
    public String test(Model model){
        Register register = null;
        try {
            register = testService.findById("刘纯林");
            if(register != null){
                System.out.println(register.toString());
                logger.info(register.toString());
            }
            model.addAttribute("a","修傻逼");
            model.addAttribute("register",register);

        } catch (Exception e) {
            logger.error("用户信息查询失败",e);
        }
        return "/index";
    }

}
