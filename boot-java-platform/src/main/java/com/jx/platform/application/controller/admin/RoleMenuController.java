package com.jx.platform.application.controller.admin;

import com.jx.platform.common.constant.BusinessConstant;
import com.jx.platform.common.response.ResponseData;
import com.jx.platform.dto.admin.*;
import com.jx.platform.entity.admin.AdminMenu;
import com.jx.platform.entity.admin.AdminMenuTree;
import com.jx.platform.framework.base.BaseController;
import com.jx.platform.service.admin.AdminLoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
     *
     * @param dto
     * @return
     */
    @PostMapping("pageRoleList")
    public ResponseData pageRoleList(@RequestBody @Validated RoleListDto dto) {
        return success(adminLoginService.pageAdminRole(dto));
    }

    /**
     * 新增角色
     *
     * @param dto
     * @return
     */
    @PostMapping("insertRole")
    public ResponseData insertRole(@RequestBody @Validated RoleInsertDto dto) {
        dto.setRoleType(BusinessConstant.ROLE_TYPE.CUSTOM.code());
        return success(adminLoginService.insertRole(dto));
    }

    /**
     * 修改角色 更新菜单
     *
     * @param dto
     * @return
     */
    @PostMapping("updateRole")
    public ResponseData updateRole(@RequestBody @Validated RoleInsertDto dto) {
        return success(adminLoginService.updateRole(dto));
    }

    /**
     * 菜单列表
     *
     * @return
     */
    @PostMapping("menuTree")
    public ResponseData menuTree() {
        String roleCode = userDetail().getRoleCode();
        if ("super".equals(roleCode)) {
            roleCode = null;
        }
        List<AdminMenu> list = adminLoginService.selectMenuByRoleCode(roleCode);
        List<AdminMenuTree> menuTrees = new ArrayList<>();
        list.stream().forEach(item -> {
            AdminMenuTree tree = new AdminMenuTree();
            BeanUtils.copyProperties(item, tree);
            menuTrees.add(tree);
        });

        Map<String, List<AdminMenuTree>> zoneByParentIdMap = menuTrees.stream().collect(Collectors.groupingBy(AdminMenuTree::getParentMenu));

        menuTrees.forEach(menu -> menu.setChildren(zoneByParentIdMap.get(menu.getMenuCode())));

        List<AdminMenuTree> result = menuTrees.stream().filter(v -> v.getParentMenu().equals("ROOT")).collect(Collectors.toList());
        sortMenuTree(result);
        return success(result);
    }

    private void sortMenuTree(List<AdminMenuTree> result) {
        Collections.sort(result);
        result.stream().forEach(item -> {
            if (item.getChildren() != null && !item.getChildren().isEmpty()) {
                sortMenuTree(item.getChildren());
            }
        });

    }
    /**
     * 菜单列表
     *
     * @param dto
     * @return
     */
    @PostMapping("menuListByLevel")
    public ResponseData menuListByLevel(@RequestBody @Validated MenuListLevelDto dto) {
        List<AdminMenu> list = adminLoginService.selectMenuByLevel(dto.getMenuLevel());
        return success(list);
    }
    /**
     * 菜单列表
     *
     * @param dto
     * @return
     */
    @PostMapping("pageMenuList")
    public ResponseData pageMenuList(@RequestBody @Validated MenuListDto dto) {
        return success(adminLoginService.pageAdminMenu(dto));
    }

    /**
     * 更新菜单信息
     *
     * @param dto
     * @return
     */
    @PostMapping("updateMenu")
    public ResponseData updateMenu(@RequestBody @Validated MenuInsertDto dto) {
        return success(adminLoginService.updateMenu(dto));
    }

    /**
     * 新增菜单信息
     *
     * @param dto
     * @return
     */
    @PostMapping("insertMenu")
    public ResponseData insertMenu(@RequestBody @Validated MenuInsertDto dto) {
        return success(adminLoginService.insertMenu(dto));
    }
}
