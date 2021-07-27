package com.jx.platform.application.controller.home;

import com.alibaba.fastjson.JSONObject;
import com.jx.platform.common.response.ResponseData;
import com.jx.platform.framework.base.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController extends BaseController {

    @PostMapping("userInfo")
    public ResponseData userInfo(){
        JSONObject json = new JSONObject();
        json.put("username", "username");
        json.put("info", "info");

        return success(json);
    }

}
