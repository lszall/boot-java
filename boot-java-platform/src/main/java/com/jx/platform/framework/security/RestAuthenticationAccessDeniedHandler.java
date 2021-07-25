package com.jx.platform.framework.security;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.common.response.ResponseType;
import com.jx.platform.common.response.ResponseUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * spring security 过滤链中异常无法被全局异常处理 配置该类处理异常
 */
public class RestAuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) {
        ResponseData data = new ResponseData(ResponseType.AUTH_ERROR);
        data.setMsg(e.getMessage());
        ResponseUtil.writeJson(response, data);
    }

}
