package com.jx.platform.framework.security;

import com.jx.platform.entity.admin.AdminLogin;
import com.jx.platform.service.admin.AdminLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class PlatfromUserDetailService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(PlatfromUserDetailService.class);


    @Autowired
    private AdminLoginService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminLogin adminLogin = adminService.selectAdminLoginByAccount(username);
        if (adminLogin == null) {
            log.error("用户不存在：{}",username);
            throw new UsernameNotFoundException(username);
        }
        PlatformUserDetail userDetail = new PlatformUserDetail();
        userDetail.setSalt("jxxx");
        userDetail.setUsername(adminLogin.getAccount());
        userDetail.setPassword(adminLogin.getPassword());
        userDetail.setRoleCdoe(adminLogin.getRoleCode());
        userDetail.setLastLoginTime(adminLogin.getLastLoginTime());
        userDetail.setLocked("Y".equalsIgnoreCase(adminLogin.getStatus()) ? false : true);
        userDetail.setAuthorities(Arrays.asList("ROLE_"+adminLogin.getRoleCode()).stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList()));
        return userDetail;
    }


}
