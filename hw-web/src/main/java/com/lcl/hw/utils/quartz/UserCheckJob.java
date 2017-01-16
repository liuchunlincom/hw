package com.lcl.hw.utils.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Rain on 2017/1/13 16:37.
 */
@Component
public class UserCheckJob {
    private Logger log = LoggerFactory.getLogger(UserCheckJob.class);
    public void runTask(){
        System.out.println("===========runTask()");
        log.info("===========runTask()");
    }
}
