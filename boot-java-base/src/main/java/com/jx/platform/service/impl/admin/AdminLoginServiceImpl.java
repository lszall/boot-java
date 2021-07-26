package com.jx.platform.service.impl.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jx.platform.common.exception.BussinessException;
import com.jx.platform.dao.admin.AdminLoginMapper;
import com.jx.platform.dao.admin.AdminMenuMapper;
import com.jx.platform.dao.admin.AdminRoleMapper;
import com.jx.platform.dto.admin.MenuInsertDto;
import com.jx.platform.dto.admin.MenuListDto;
import com.jx.platform.dto.admin.RoleInsertDto;
import com.jx.platform.dto.admin.RoleListDto;
import com.jx.platform.entity.admin.AdminLogin;
import com.jx.platform.entity.admin.AdminMenu;
import com.jx.platform.entity.admin.AdminRole;
import com.jx.platform.service.admin.AdminLoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private AdminLoginMapper adminLoginMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Autowired
    private AdminMenuMapper adminMenuMapper;

    @Override
    public AdminLogin selectAdminLoginByAccount(String account) {
        return adminLoginMapper.selectByAccount(account);
    }

    @Override
    public int updateAdminLastLoginTime(AdminLogin adminLogin) {
        return adminLoginMapper.updateByPrimaryKeySelective(adminLogin);
    }


    @Override
    public PageInfo<AdminRole> pageAdminRole(RoleListDto dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return new PageInfo<>(adminRoleMapper.listAdminRole(dto));
    }

    @Override
    public List<AdminMenu> selectMenuByRoleCode(String roleCode) {
        return adminMenuMapper.selectByRoleCode(roleCode);
    }

    @Override
    @Transactional
    public int updateRole(RoleInsertDto dto) {
        adminRoleMapper.deleteRoleMenus(dto);
        adminRoleMapper.insertRoleMenus(dto);
        return adminRoleMapper.updateByPrimaryKeySelective(dto);
    }

    @Override
    public int insertRole(RoleInsertDto dto) {
        AdminRole role = adminRoleMapper.selectByPrimaryKey(dto.getRoleCode());
        if (role != null) {
            throw new BussinessException("该角色已存在！");
        }
        adminRoleMapper.insertRoleMenus(dto);
        return adminRoleMapper.insert(dto);
    }

    @Override
    public PageInfo<AdminMenu> pageAdminMenu(MenuListDto dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return new PageInfo<>(adminMenuMapper.listAdminMenu(dto));
    }

    @Override
    public int updateMenu(MenuInsertDto dto) {
        return adminMenuMapper.updateByPrimaryKeySelective(dto);
    }

    @Override
    public int insertMenu(MenuInsertDto dto) {
        AdminMenu menu=adminMenuMapper.selectByPrimaryKey(dto.getMenuCode());
        if(menu!=null){
            throw new BussinessException("该菜单已存在！");
        }
        menu = adminMenuMapper.selectByPrimaryKey(dto.getParentMenu());
        if(menu==null){
            throw new BussinessException("父级菜单不存在！");
        }
        return adminMenuMapper.insert(dto);
    }
}
