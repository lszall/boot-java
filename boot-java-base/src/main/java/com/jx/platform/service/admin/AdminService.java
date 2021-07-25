package com.jx.platform.service.admin;

import com.jx.platform.entity.admin.AdminLogin;

public interface AdminService {
    /**
     *
     * 根据账号查询admin登录信息
     * @param account:
     * @return com.boot.application.entity.AdminLogin
     * @author lsz
     * @date 2021-07-11 10:16:28
     */
    AdminLogin selectAdminLoginByAccount(String account);
    /**
     *
     * 更新最后登录时间
     * @param adminLogin:
     * @return com.boot.application.entity.AdminLogin
     * @author lsz
     * @date 2021-07-11 10:16:28
     */
    int updateAdminLastLoginTime(AdminLogin adminLogin);
}
