package com.lcl.hw.services;

import com.lcl.hw.domain.JobInfo;

/**
 * Created by Rain on 2017/3/15 14:02.
 */
public interface JobInfoService {
    public JobInfo findByJobId() throws Exception;
}
