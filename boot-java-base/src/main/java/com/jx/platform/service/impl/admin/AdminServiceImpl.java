package com.jx.platform.service.impl.admin;

import com.jx.platform.dao.admin.AdminLoginMapper;
import com.jx.platform.entity.admin.AdminLogin;
import com.jx.platform.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminLoginMapper adminLoginMapper;

    @Override
    public AdminLogin selectAdminLoginByAccount(String account) {
        return adminLoginMapper.selectByAccount(account);
    }

    @Override
    public int updateAdminLastLoginTime(AdminLogin adminLogin) {
        return adminLoginMapper.updateByPrimaryKeySelective(adminLogin);
    }
}
