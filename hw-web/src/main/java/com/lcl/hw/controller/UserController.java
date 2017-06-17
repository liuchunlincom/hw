package com.lcl.hw.controller;

import com.lcl.hw.domain.UserInfo;
import com.lcl.hw.services.UserService;
import com.lcl.hw.utils.RetObj;
import com.lcl.hw.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Resource
    private UserUtils userUtils;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value={"","login"})
    @ResponseBody
    public RetObj login(UserInfo userInfo,Model model){
        RetObj retObj = new RetObj();
        try {
            retObj = userService.login(userInfo);
            if(retObj!=null && retObj.isSuccess()){
                userUtils.setHttpUserSession((UserInfo)retObj.getResult());
            }
        } catch (Exception e) {
            retObj.setSuccess(false);
            retObj.setMessage("登录异常！");
            logger.error("登录异常",e);
        }
        logger.info(retObj.toString());
        model.addAttribute("result",retObj);
        return retObj;
    }

}
