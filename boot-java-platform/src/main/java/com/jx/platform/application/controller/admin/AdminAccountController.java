package com.jx.platform.application.controller.admin;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.dto.admin.AccountListDto;
import com.jx.platform.dto.admin.AccountLockDto;
import com.jx.platform.dto.admin.AccountRestPwdDto;
import com.jx.platform.framework.base.BaseController;
import com.jx.platform.framework.security.PlatformPasswordEncoder;
import com.jx.platform.service.admin.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/account")
public class AdminAccountController extends BaseController {

    @Autowired
    private AdminLoginService adminLoginService;

    /**
     * 账号 列表
     *
     * @param dto
     * @return
     */
    @PostMapping("pageAccountList")
    public ResponseData pageAccountList(@RequestBody @Validated AccountListDto dto) {
        return success(adminLoginService.pageAdminAccount(dto));
    }

    /**
     * 锁定/解锁 账号
     *
     * @param dto
     * @return
     */
    @PostMapping("lockAccount")
    public ResponseData lockAccount(@RequestBody @Validated AccountLockDto dto) {
        if (dto.getAccount().equals("super")) {
            return failure("无法锁定超级管理员");
        }
        return success(adminLoginService.lockAccount(dto));
    }

    /**
     * 重置密码
     *
     * @param dto
     * @return
     */
    @PostMapping("resetPwd")
    public ResponseData resetPwd(@RequestBody @Validated AccountRestPwdDto dto) {
        PlatformPasswordEncoder encoder = new PlatformPasswordEncoder();
        dto.setPassword(encoder.encode("123456"));
        return success(adminLoginService.resetPwd(dto));
    }


}