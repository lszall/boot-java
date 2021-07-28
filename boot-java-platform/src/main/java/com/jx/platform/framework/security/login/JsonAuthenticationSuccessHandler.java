package com.jx.platform.framework.security.login;

import com.jx.platform.common.constant.RedisConstant;
import com.jx.platform.common.request.RequestUtil;
import com.jx.platform.common.response.ResponseData;
import com.jx.platform.common.response.ResponseType;
import com.jx.platform.common.response.ResponseUtil;
import com.jx.platform.entity.admin.AdminLogin;
import com.jx.platform.framework.security.PlatformUserDetail;
import com.jx.platform.framework.security.jwt.TokenAuthenticationHelper;
import com.jx.platform.service.admin.AdminLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static com.jx.platform.common.constant.RedisConstant.TOKEN_CREATE_TIME;

@Component
public class JsonAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger log = LoggerFactory.getLogger(JsonAuthenticationSuccessHandler.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AdminLoginService adminService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        PlatformUserDetail detail = null;
        String username = "";
        ResponseData data = new ResponseData(ResponseType.SUCCESS);
        if (authentication.getPrincipal() instanceof PlatformUserDetail) {
            detail = (PlatformUserDetail) authentication.getPrincipal();
            username = detail.getUsername();
            LocalDateTime now = LocalDateTime.now();
            redisTemplate.opsForValue().set(TOKEN_CREATE_TIME + username, now, TokenAuthenticationHelper.EXPIRATION_TIME, TimeUnit.MILLISECONDS);
            log.info("{}:{}登录成功", username, now);
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.setAccount(username);
            adminLogin.setLastLoginTime(now);
            adminService.updateAdminLastLoginTime(adminLogin);
            detail.setLastLoginTime(now);
            data.setData(TokenAuthenticationHelper.generateToken(detail));
            redisTemplate.delete(RedisConstant.LOGIN_FAIL_COUNT + RequestUtil.getIpAddress(request));
        } else {
            data.setCode(ResponseType.AUTH_ERROR);
        }

        ResponseUtil.writeJson(response, data);
    }

}
