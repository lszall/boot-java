package com.jx.platform.application.controller.admin;

import com.jx.platform.common.exception.BussinessException;
import com.jx.platform.common.response.ResponseData;
import com.jx.platform.dto.admin.AccountChangePhoneDto;
import com.jx.platform.dto.admin.AccountRestPasswordDto;
import com.jx.platform.entity.admin.AdminLogin;
import com.jx.platform.framework.base.BaseController;
import com.jx.platform.service.admin.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static com.jx.platform.common.constant.RedisConstant.TOKEN_CREATE_TIME;

/**
 * 用户操作自己账号  密码修改，手机号修改
 */
@RestController
@RequestMapping("account")
public class AccountController extends BaseController {
    @Autowired
    private AdminLoginService adminLoginService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    /**
     * 用户重置密码
     *
     * @param dto
     * @return
     */
    @PostMapping("resetPwd")
    public ResponseData resetPwd(@RequestBody @Validated AccountRestPasswordDto dto) {
        AdminLogin adminLogin = adminLoginService.selectAdminLoginByAccount(userDetail().getUsername());
        if (!passwordEncoder.matches(adminLogin.getPassword(), dto.getOldPassword())) {
            throw new BussinessException("原密码错误！");
        }
        adminLogin = new AdminLogin();
        adminLogin.setAccount(userDetail().getUsername());
        adminLogin.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        adminLogin.setUpdateTime(LocalDateTime.now());
        int result = adminLoginService.updateByPrimaryKeySelective(adminLogin);
        if (result > 0) {
            redisTemplate.delete(TOKEN_CREATE_TIME + adminLogin.getAccount());

        }
        return success(result);
    }

    /**
     * 用户修改手机号
     *
     * @param dto
     * @return
     */
    @PostMapping("changePhone")
    public ResponseData changePhone(@RequestBody @Validated AccountChangePhoneDto dto) {
        AdminLogin adminLogin = adminLoginService.selectAdminLoginByAccount(userDetail().getUsername());
        if (!passwordEncoder.matches(adminLogin.getPassword(), dto.getPassword())) {
            throw new BussinessException("密码错误！");
        }
        adminLogin = new AdminLogin();
        adminLogin.setUpdateTime(LocalDateTime.now());
        adminLogin.setPhone(dto.getPhone());
        adminLogin.setAccount(userDetail().getUsername());
        int result = adminLoginService.updateByPrimaryKeySelective(adminLogin);
        if (result > 0) {
            redisTemplate.delete(TOKEN_CREATE_TIME + adminLogin.getAccount());
        }
        return success(result);
    }
}
