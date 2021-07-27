package com.jx.platform.application.controller.admin;

import com.jx.platform.common.exception.BussinessException;
import com.jx.platform.common.response.ResponseData;
import com.jx.platform.dto.admin.AccountChangePhoneDto;
import com.jx.platform.dto.admin.AccountRestPasswordDto;
import com.jx.platform.entity.admin.AdminLogin;
import com.jx.platform.framework.base.BaseController;
import com.jx.platform.framework.security.PlatformPasswordEncoder;
import com.jx.platform.service.admin.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("account")
public class AccountController extends BaseController {
    @Autowired
    private AdminLoginService adminLoginService;

    /**
     * 用户重置密码
     *
     * @param dto
     * @return
     */
    @PostMapping("resetPwd")
    public ResponseData resetPwd(@RequestBody @Validated AccountRestPasswordDto dto) {
        PlatformPasswordEncoder encoder = new PlatformPasswordEncoder();
        AdminLogin adminLogin = adminLoginService.selectAdminLoginByAccount(userDetail().getUsername());
        if (!encoder.matches(adminLogin.getPassword(), dto.getOldPassword())) {
            throw new BussinessException("原密码错误！");
        }
        adminLogin = new AdminLogin();
        adminLogin.setAccount(userDetail().getUsername());
        adminLogin.setPassword(encoder.encode(dto.getNewPassword()));
        adminLogin.setUpdateTime(LocalDateTime.now());
        return success(adminLoginService.updateByPrimaryKeySelective(adminLogin));
    }

    /**
     * 用户重置密码
     *
     * @param dto
     * @return
     */
    @PostMapping("changePhone")
    public ResponseData changePhone(@RequestBody @Validated AccountChangePhoneDto dto) {
        PlatformPasswordEncoder encoder = new PlatformPasswordEncoder();
        AdminLogin adminLogin = adminLoginService.selectAdminLoginByAccount(userDetail().getUsername());
        if (!encoder.matches(adminLogin.getPassword(), dto.getPassword())) {
            throw new BussinessException("密码错误！");
        }
        adminLogin = new AdminLogin();
        adminLogin.setUpdateTime(LocalDateTime.now());
        adminLogin.setPhone(dto.getPhone());
        adminLogin.setAccount(userDetail().getUsername());
        return success(adminLoginService.updateByPrimaryKeySelective(adminLogin));
    }
}
