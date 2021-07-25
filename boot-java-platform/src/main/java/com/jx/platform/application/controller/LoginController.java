package com.jx.platform.application.controller;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.common.response.ResponseType;
import com.jx.platform.framework.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends BaseController {



    @RequestMapping("/loginFailure")
    public ResponseData loginFailure(){


        return new ResponseData(ResponseType.METHOD_ERROR);
    }

}
