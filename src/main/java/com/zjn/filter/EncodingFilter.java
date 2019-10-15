package com.zjn.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

public class EncodingFilter implements Filter {

    private String encoding;
    private HashMap<String,String> params = new HashMap<String,String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("begin do the encoding filter!");
        encoding = filterConfig.getInitParameter("encoding");
        for (Enumeration<?> e = filterConfig.getInitParameterNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            String value = filterConfig.getInitParameter(name);
            params.put(name, value);
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("before encoding " + encoding + " filter！");
        servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after encoding " + encoding + " filter！");
        System.err.println("----------------------------------------");

    }

    @Override
    public void destroy() {
        System.out.println("end do the encoding filter!");
        params=null;
        encoding=null;

    }
}
