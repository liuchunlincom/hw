package com.lcl.hw.mapper;

import com.lcl.hw.domain.JobInfo;

/**
 * Created by Rain on 2017/3/15 14:04.
 */
public interface JobInfoMapper {
    public JobInfo findByJobId(String id) throws Exception;
}
