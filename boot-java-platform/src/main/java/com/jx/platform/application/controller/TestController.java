package com.jx.platform.application.controller;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.framework.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseController {


    @RequestMapping("anon/aa")
    public ResponseData Anon() {

        return new ResponseData("任何人可以访问");
    }


    @RequestMapping("login")
    public ResponseData login(){
        return new ResponseData("任hasRoleA可以访问");
    }


    @RequestMapping("hasRoleA")
    public ResponseData hasRoleA(){
        int a = 0;
        int b = 3;
        System.out.println(b/a);
        return new ResponseData("任hasRoleA可以访问");
    }

}
