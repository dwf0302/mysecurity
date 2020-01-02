package com.bree.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;
//过滤器要起作用需要添加@Component 如果第三方过滤器无法添加注解 配置文件进行配置
//过滤器缺点，拿不到方法和参数相关东西
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter start");
        long startTime = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("time filter" + (new Date().getTime()-startTime));
        System.out.println("time filter end");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
