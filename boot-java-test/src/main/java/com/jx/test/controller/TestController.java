package com.jx.test.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jx.platform.common.response.ResponseData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {


    @Value("${server.port}")
    private String port;
    @Value("${server.name}")
    private String name;

    @RequestMapping("serverInfo")
    public ResponseData serverInfo() {
        JSONObject result = new JSONObject();
        result.put("SERVER-NAME", name);
        result.put("SERVER-PORT", port);
        return new ResponseData(result);
    }

    @RequestMapping("occupyCPU")
    public ResponseData occupyCPU() {

        for (int i = 0; i < 100; i++) {
          Thread t=new Thread(new Apples());
          t.start();

        }
        return new ResponseData();
    }


}
