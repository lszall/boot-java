package com.jx.platform.application.controller;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.common.response.ResponseType;
import com.jx.platform.entity.sys.SysActionLog;
import com.jx.platform.framework.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class RedisController extends BaseController{

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("anon/redis/a")
    public ResponseData a(String a){
        SysActionLog log = new SysActionLog();
        log.setSuccess("Y");
        log.setResponse("response");
        log.setUsername("username");
        log.setCreateDate(LocalDateTime.now());
       boolean dd= redisTemplate.opsForValue().setIfAbsent("A", a);

      Object object=  redisTemplate.opsForValue().get("log");

      if(object instanceof SysActionLog){
          return new ResponseData(object);
      }

        return success();
    }
}
