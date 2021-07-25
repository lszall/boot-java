package com.jx.platform.application.controller;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.framework.base.BaseController;
import com.jx.platform.framework.security.PlatformUserDetail;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AuthController
 * @Description:
 * @Author: lsz
 * @Date: 2020/3/27 16:27
 * @version: v1.0
 **/
@RestController
@RequestMapping("authenticated")
public class AuthController extends BaseController {
    @RequestMapping("a")
    public ResponseData getA() {
        return new ResponseData(userDetail());
    }

    @RequestMapping("b")
    public ResponseData getB() {
        return new ResponseData("auth-B");
    }

    @RequestMapping("c")
    public ResponseData getC() {
        return new ResponseData("auth-C");
    }

    @RequestMapping("d")
    @PreAuthorize("hasRole('edmin')")
    public ResponseData getD() {
        return new ResponseData("auth-D");
    }

    @PostMapping("f")
    public ResponseData getF() {
        return new ResponseData("auth-F");
    }
}
