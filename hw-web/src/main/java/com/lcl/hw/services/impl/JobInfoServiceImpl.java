package com.lcl.hw.services.impl;

import com.lcl.hw.domain.JobInfo;
import com.lcl.hw.mapper.JobInfoMapper;
import com.lcl.hw.services.JobInfoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Rain on 2017/3/15 14:03.
 */
@Component
public class JobInfoServiceImpl implements JobInfoService{
    @Resource
    private JobInfoMapper jobInfoMapper;
    @Override
    public JobInfo findByJobId() throws Exception {
        JobInfo jobInfo = jobInfoMapper.findByJobId("123");
        return null;
    }
}
