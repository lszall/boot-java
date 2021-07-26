package com.jx.platform.framework.config.aop;

import com.jx.platform.common.request.BodyReaderHttpServletRequestWrapper;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        BodyReaderHttpServletRequestWrapper requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
        if (requestWrapper == null) {
            doFilter(httpServletRequest, httpServletResponse, filterChain);
        } else {
            doFilter(requestWrapper, httpServletResponse, filterChain);
        }
    }
}
