package com.jx.platform.application.controller.admin;

import com.jx.platform.common.constant.BusinessConstant;
import com.jx.platform.common.response.ResponseData;
import com.jx.platform.dto.admin.MenuInsertDto;
import com.jx.platform.dto.admin.MenuListDto;
import com.jx.platform.dto.admin.RoleInsertDto;
import com.jx.platform.dto.admin.RoleListDto;
import com.jx.platform.framework.base.BaseController;
import com.jx.platform.service.admin.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色 菜单
 */
@RestController
@RequestMapping("/admin/roleMenu")
public class RoleMenuController extends BaseController {


    @Autowired
    private AdminLoginService adminLoginService;

    /**
     * 角色 列表
     * @param dto
     * @return
     */
    @PostMapping("pageRoleList")
    public ResponseData pageRoleList(@RequestBody RoleListDto dto){
        return success(adminLoginService.pageAdminRole(dto));
    }

    /**
     * 新增角色
     * @param dto
     * @return
     */
    @PostMapping("insertRole")
    public ResponseData insertRole(@RequestBody RoleInsertDto dto){
        dto.setRoleType(BusinessConstant.ROLE_TYPE.CUSTOM.code());
        return success(adminLoginService.insertRole(dto));
    }

    /**
     * 修改角色 更新菜单
     * @param dto
     * @return
     */
    @PostMapping("updateRole")
    public ResponseData updateRole(@RequestBody RoleInsertDto dto){
        return success(adminLoginService.updateRole(dto));
    }

    /**
     * 菜单列表
     * @param dto
     * @return
     */
    @PostMapping("pageMenuList")
    public ResponseData pageMenuList(@RequestBody MenuListDto dto){
        return success(adminLoginService.pageAdminMenu(dto));
    }

    /**
     * 更新菜单信息
     * @param dto
     * @return
     */
    @PostMapping("updateMenu")
    public ResponseData updateMenu(@RequestBody MenuInsertDto dto){
        return success(adminLoginService.updateMenu(dto));
    }

    /**
     * 新增菜单信息
     * @param dto
     * @return
     */
    @PostMapping("insertMenu")
    public ResponseData insertMenu(@RequestBody MenuInsertDto dto){
        return success(adminLoginService.insertMenu(dto));
    }
}
