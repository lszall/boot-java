package com.jx.platform.framework.security.login;

import com.jx.platform.common.constant.RedisConstant;
import com.jx.platform.common.request.RequestUtil;
import com.jx.platform.common.response.ResponseData;
import com.jx.platform.common.response.ResponseType;
import com.jx.platform.common.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class JsonAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger log = LoggerFactory.getLogger(JsonAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info(" 登录失败--");
        String username = request.getSession().getAttribute("username").toString();
        ResponseData data = new ResponseData(ResponseType.AUTH_ERROR);
        if (exception instanceof UsernameNotFoundException) {
            data.setMsg("用户名不存在");
        }
        if (exception instanceof BadCredentialsException) {
            redisTemplate.opsForValue().increment(RedisConstant.LOGIN_FAIL_COUNT + RequestUtil.getIpAddress(request));
            redisTemplate.expire(RedisConstant.LOGIN_FAIL_COUNT + RequestUtil.getIpAddress(request), 300, TimeUnit.SECONDS);
            data.setMsg("密码错误");
        }
        ResponseUtil.writeJson(response, data);

    }
}
