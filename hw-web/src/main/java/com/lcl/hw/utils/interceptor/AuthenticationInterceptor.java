package com.lcl.hw.utils.interceptor;

import com.lcl.hw.domain.Register;
import com.lcl.hw.utils.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Rain on 2017/1/16 13:41.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Register register = (Register)request.getSession().getAttribute(Constants.AGENT_SESSION);
        if(register==null){
            response.sendRedirect("/login/toLogin");
            return false;
        }else{
            return super.preHandle(request,response,handler);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
