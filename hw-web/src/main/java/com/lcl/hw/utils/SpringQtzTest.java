package com.lcl.hw.utils;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by Rain on 2017/1/13 16:06.
 */
public class SpringQtzTest extends QuartzJobBean {
    private static int counter = 0;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println();
        long ms = System.currentTimeMillis();
        System.out.println("\t\t" + new Date(ms));
        System.out.println(ms);
        System.out.println("(" + counter++ + ")");
        String s = (String) jobExecutionContext.getMergedJobDataMap().get("service");
        System.out.println(s);
        System.out.println();
    }
}
