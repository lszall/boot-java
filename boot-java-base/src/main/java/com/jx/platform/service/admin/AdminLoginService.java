package com.jx.platform.service.admin;

import com.github.pagehelper.PageInfo;
import com.jx.platform.dto.admin.MenuInsertDto;
import com.jx.platform.dto.admin.MenuListDto;
import com.jx.platform.dto.admin.RoleInsertDto;
import com.jx.platform.dto.admin.RoleListDto;
import com.jx.platform.entity.admin.AdminLogin;
import com.jx.platform.entity.admin.AdminMenu;
import com.jx.platform.entity.admin.AdminRole;

import java.util.List;

/**
 * 登录 账号 密码 角色 菜单 操作
 */
public interface AdminLoginService {
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

    /**
     * 分页角色
     *
     * @return
     */
    PageInfo<AdminRole> pageAdminRole(RoleListDto dto);
    /**
     * 查询角色菜单信息
     *
     * @param roleCode:   角色编码
     * @return com.jx.platform.entity.admin.AdminMenu
     * @author lsz
     * @date 2021-07-26 15:04:39
     */
    List<AdminMenu> selectMenuByRoleCode(String roleCode);

    /**
     * 更新角色 并设置角色菜单
     * @return
     */
    int updateRole(RoleInsertDto dto);
    /**
     * 新增角色 并设置角色菜单
     * @return
     */
    int insertRole(RoleInsertDto dto);


    /**
     * 分页菜单
     *
     * @return
     */
    PageInfo<AdminMenu> pageAdminMenu(MenuListDto dto);
    /**
     * 更新菜单
     * @return
     */
    int updateMenu(MenuInsertDto dto);
    /**
     * 新增菜单
     * @return
     */
    int insertMenu(MenuInsertDto dto);


}
