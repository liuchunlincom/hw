package com.lcl.hw.utils;

import com.lcl.hw.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rain on 2017/1/17 16:39.
 */
@Component
public class UserUtils {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RedisUtil redisUtil;

    /**
     * 获取特定格式的系统时间
     * @param format 格式化规则
     * @return
     */
    public String getSystemDateToString(String format){
        String dateStr = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        dateStr = sdf.format(new Date());
        return dateStr;
    }

    /**
     * 格式化日期
     * @param date 待格式化的日期
     * @param format 格式化规则
     * @return
     */
    public String dateToString(Date date, String format){
        String dateStr = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 获取系统时间
     * @return
     */
    public Date getSystemDate(){
        return new Date();
    }

    /**
     * 获取会话
     * @return
     */
    public HttpSession getHttpSession(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes == null){
            return null;
        }
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return  request.getSession();
    }

    /**
     * 获取当前登录用户信息
     * @return
     */
    public UserInfo getHttpUserSession(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes == null){
            return null;
        }
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return (UserInfo) request.getSession().getAttribute(Constants.AGENT_SESSION);
    }

    /**
     * 登录用户信息存入会话中
     * @return
     */
    public boolean setHttpUserSession(UserInfo userInfo){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes == null){
            logger.error("获取会话信息失败，无法缓存当前用户登录信息");
            return false;
        }

        HttpServletRequest request = servletRequestAttributes.getRequest();
        request.getSession().setAttribute(Constants.AGENT_SESSION, userInfo);
        request.getSession().setAttribute("loginTime_"+userInfo.getUserid(),new Date());
        logger.info("当前用户登录信息已缓存："+userInfo.toString());
        return true;
    }
}
