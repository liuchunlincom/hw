package com.lcl.hw.services.impl;

import com.lcl.hw.domain.UserInfo;
import com.lcl.hw.mapper.UserInfoMapper;
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
    private UserInfoMapper userInfoMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public RetObj login(UserInfo userInfo) throws Exception {

        UserInfo user = userInfoMapper.findByUserId(userInfo.getUserid());
        RetObj retObj = new RetObj();
        if(user == null){
            retObj.setMessage("用户不存在！");
            retObj.setSuccess(false);
            logger.info("用户不存在！");
        }else if(user.getPassword().equals(userInfo.getPassword())){//密码验证通过
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
