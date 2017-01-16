package com.lcl.hw.services.impl;

import com.lcl.hw.domain.Register;
import com.lcl.hw.mapper.RegisterMapper;
import com.lcl.hw.services.UserService;
import com.lcl.hw.utils.RetObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Rain on 2016/12/22 19:27.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private RegisterMapper registerMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public RetObj login(Register register) throws Exception {

        Register user = registerMapper.findByLoginid(register.getLoginid());
        RetObj retObj = new RetObj();
        if(user == null){
            retObj.setMessage("用户不存在！");
            retObj.setSuccess(false);
            logger.info("用户不存在！");
        }else if(user.getPassword().equals(register.getPassword())){//密码验证通过
            retObj.setMessage("密码验证通过！");
            retObj.setSuccess(true);
            retObj.setResult(user);
            logger.info("密码验证通过！");
        }else{//密码验证失败
            logger.info("密码验证失败！");
            retObj.setMessage("密码验证失败！");
            retObj.setSuccess(false);
        }
        return retObj;
    }
}
