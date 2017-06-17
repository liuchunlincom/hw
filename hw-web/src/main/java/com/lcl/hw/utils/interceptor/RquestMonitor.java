package com.lcl.hw.utils.interceptor;

import com.lcl.hw.domain.UserInfo;
import com.lcl.hw.utils.Constants;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Rain on 2017/4/21 9:08.
 */
public class RquestMonitor extends HandlerInterceptorAdapter {
    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("WatchExecuteTime");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();            //开始时间
        startTimeThreadLocal.set(beginTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTimeThreadLocal.get();
        System.out.println(String.format("%s execute %d ms." , httpServletRequest.getRequestURI() , executeTime));
    }
}
