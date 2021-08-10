package com.jx.platform.framework.security;


import com.jx.platform.common.response.ResponseData;
import com.jx.platform.common.response.ResponseType;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName NotFoundExceptionHandler
 * @Description: 捕获SpringSecurity过滤连中的异常 401、403异常
 * @Author: lsz
 * @Date: 2019/12/17 14:44
 * @version: v1.0
 **/
@RestController
public class NotFoundExceptionHandler implements ErrorController {
    /**
     * 这里配置404路径 必须是“/error”
     */
    private static final String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(ERROR_PATH)
    public ResponseData error404(HttpServletResponse response) {
        ResponseData responseData=  new ResponseData(ResponseType.AUTH_ERROR);
        response.setStatus(HttpServletResponse.SC_OK);
        return responseData;
    }
}
