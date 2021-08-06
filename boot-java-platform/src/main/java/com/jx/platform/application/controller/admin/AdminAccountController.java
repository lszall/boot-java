package com.jx.platform.application.controller.admin;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.dto.admin.AccountListDto;
import com.jx.platform.dto.admin.AccountLockDto;
import com.jx.platform.dto.admin.AccountRestPwdDto;
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
 * 超级管理员对账号操作
 */
@RestController
@RequestMapping("admin/account")
public class AdminAccountController extends BaseController {

    @Autowired
    private AdminLoginService adminLoginService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
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
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.setAccount(dto.getAccount());
        adminLogin.setStatus(dto.getLock());
        int result = adminLoginService.updateByPrimaryKeySelective(adminLogin);
        if (result > 0) {
            redisTemplate.delete(TOKEN_CREATE_TIME + adminLogin.getAccount());

        }
        return success(result);
    }


    /**
     * 重置密码
     *
     * @param dto
     * @return
     */
    @PostMapping("resetPwd")
    public ResponseData resetPwd(@RequestBody @Validated AccountRestPwdDto dto) {
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.setAccount(dto.getAccount());
        adminLogin.setPassword(passwordEncoder.encode("123456"));
        adminLogin.setUpdateTime(LocalDateTime.now());
        int result = adminLoginService.updateByPrimaryKeySelective(adminLogin);
        if (result > 0) {
            redisTemplate.delete(TOKEN_CREATE_TIME + adminLogin.getAccount());

        }
        return success(result);
    }


}
