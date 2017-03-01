package com.lcl.hw.utils.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * Created by Rain on 2017/1/17 17:15.
 */
public class logFilter implements Filter {
    private FilterConfig filterConfig;

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
