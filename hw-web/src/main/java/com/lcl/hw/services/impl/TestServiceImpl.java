package com.lcl.hw.services.impl;

import com.lcl.hw.domain.Register;
import com.lcl.hw.mapper.RegisterMapper;
import com.lcl.hw.services.TestService;
import com.lcl.hw.utils.TestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;


/**
 * Created by Rain on 2016/12/13 18:44.
 */
@Service
public class TestServiceImpl implements TestService ,Serializable{
    @Resource
    private RegisterMapper registerMapper;

    public Register findById(String loginid) throws Exception {
        new TestUtils().testOracle();
        return registerMapper.findByLoginid(loginid);
//        return null;
    }
}
