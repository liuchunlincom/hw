package com.lcl.hw.controller;

import com.lcl.hw.domain.Register;
import com.lcl.hw.services.UserService;
import com.lcl.hw.utils.RetObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 用户登录
 * Created by Rain on 2016/12/22 19:18.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value={"","login"})
    public String login(Register register,Model model){
        String pw = register.getPassword();
        RetObj retObj = new RetObj();
        try {
            retObj = userService.login(register);
        } catch (Exception e) {
            retObj.setSuccess(false);
            retObj.setMessage("登录异常！");
            logger.error("登录异常",e);
        }
        logger.info(retObj.toString());
        model.addAttribute("result",retObj);
        return "/index";
    }

}
