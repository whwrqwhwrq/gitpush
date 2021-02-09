package com.example.redisjedis.configs;

import com.google.common.collect.Maps;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author:wrq
 * @Date:2021/1/8 9:09
 */
@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean<Filter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new CustomFilter());
        HashSet<String> urlPatterns = new HashSet<>();
        urlPatterns.add("/*");
        frb.setUrlPatterns(urlPatterns);
        frb.setName("myFilter");
        Map<String, String> parameters = Maps.newHashMap();
        parameters.put("key", "value");
        frb.setInitParameters(parameters);
        frb.setOrder(1);
        return frb;
    }

    public class CustomFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            System.out.println("请求地址："+httpServletRequest.getRequestURI());
            filterChain.doFilter(request,response);
        }

        @Override
        public void destroy() {

        }
    }
}
