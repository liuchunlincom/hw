package com.lcl.hw.utils.filter;
import com.lcl.hw.domain.UserInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Rain on 2017/3/14 19:00.
 */
public class loginFitler implements Filter {
    private String excludedPages;
    private String[] excludedPageArray;
    //private Logger logger = LoggerFactory.getLogger(this.getClass());
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        boolean isExcludedPage = false;
        for (String page : excludedPageArray) {//判断是否在过滤url之外
            if(((HttpServletRequest) request).getServletPath().equals(page)){
                isExcludedPage = true;
                break;
            }
        }


        if(isExcludedPage){//页面不在过滤器作用范围
            chain.doFilter(req,resp);
            System.out.println("请求不在过滤器作用范围...................");
        }else{
            HttpSession session = request.getSession();
            UserInfo user = (UserInfo) session.getAttribute("user");
            if(session == null || session.getAttribute("user") == null){
                //logger.info("loginFilter...................");
                System.out.println("loginFilter...................");
                response.sendRedirect("/login/toLogin");
            }else{
                chain.doFilter(req,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {
        excludedPages = config.getInitParameter("excludedPages");
        if (StringUtils.isNotEmpty(excludedPages)) {
            excludedPageArray = excludedPages.split(",");
        }
    }

}
