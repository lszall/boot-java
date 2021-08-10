package com.jx.platform.application.controller;

import com.jx.platform.application.service.TestService;
import com.jx.platform.common.response.ResponseData;
import com.jx.platform.framework.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseController {

    @Autowired
    private TestService testService;

    @RequestMapping("anon/testaa")
    public ResponseData testaa() {
        testService.ss();

        return new ResponseData("任何人可以访问");
    }
    @RequestMapping("anon/aad")
    public ResponseData aad() {
        for (int i = 0; i <100 ; i++) {
            testService.aa(i);
        }
        return new ResponseData("任何人可以访问");
    }
    @RequestMapping("anon/aas")
    public ResponseData aas() {
        for (int i = 0; i <100 ; i++) {
            testService.aa(i);
        }
        return new ResponseData("任何人可以访问");
    }

    @RequestMapping("anon/aa")
    public ResponseData Anon() {

        return new ResponseData("任何人可以访问");
    }


    @RequestMapping("hasRoleA")
    public ResponseData hasRoleA() {
        int a = 0;
        int b = 3;
        System.out.println(b / a);
        return new ResponseData("任hasRoleA可以访问");
    }

}
