package com.jx.platform.framework.security.jwt;

import com.jx.platform.framework.security.PlatformUserDetail;
import com.jx.platform.framework.security.PlatfromUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static com.jx.platform.common.constant.RedisConstant.TOKEN_CREATE_TIME;

/**
 * 如果传递了token 那么进行token认证授权之后在放行
 * 如果没有token 或者认证失败也放行 前提是securityConfig里面对所有需要认证才能访问的路径进行了配置
 * 认证过滤链中后面的过滤器会进行验证是否认证和授权
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PlatfromUserDetailService platfromUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            JwtToken token = TokenAuthenticationHelper.getJwtToken(httpServletRequest);
            if (token != null) {
                Object obj = redisTemplate.opsForValue().get(TOKEN_CREATE_TIME + token.getSubject());
                if (obj != null && obj instanceof PlatformUserDetail) {
                    PlatformUserDetail detail = (PlatformUserDetail) obj;
                    if (TokenAuthenticationHelper.checkSign(token.getSign(), detail)) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(detail, null, detail.getAuthorities());
                        usernamePasswordAuthenticationToken.setDetails(detail);
                        // 对用 token 获取到的用户进行校验
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }

            }
        } catch (Exception e) {
            //httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token expired，登陆已过期");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
