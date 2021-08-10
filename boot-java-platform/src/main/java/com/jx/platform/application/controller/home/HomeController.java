package com.jx.platform.application.controller.home;

import com.alibaba.fastjson.JSONObject;
import com.jx.platform.common.response.ResponseData;
import com.jx.platform.entity.admin.AdminMenu;
import com.jx.platform.framework.base.BaseController;
import com.jx.platform.framework.security.PlatformUserDetail;
import com.jx.platform.service.admin.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static com.jx.platform.common.constant.RedisConstant.TOKEN_CREATE_TIME;

/**
 * 首页操作
 */
@RestController
@RequestMapping("home")
public class HomeController extends BaseController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private AdminLoginService adminLoginService;
    @PostMapping("userInfo")
    public ResponseData userInfo(){
        JSONObject json = new JSONObject();
        List<AdminMenu> list = adminLoginService.selectMenuByRoleCode(userDetail().getRoleCode());

        json.put("username", "username");
        json.put("info", "info");
        json.put("roles", Arrays.asList("editor"));
        json.put("menus", list);
        json.put("name","猪八戒");
        json.put("introduction","爱吃西瓜");
        json.put("avatar","https://www.baidu.com/img/flexible/logo/pc/result.png");

        return success(json);
    }
    @RequestMapping("logout")
    public ResponseData logout(){
        PlatformUserDetail userDetails = userDetail();
        if(userDetails!=null){
            redisTemplate.delete(TOKEN_CREATE_TIME + userDetails.getUsername());
        }
        return success();
    }


}
