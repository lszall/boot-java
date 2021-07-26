package com.jx.platform.dto.admin;

import lombok.Data;

import java.util.List;

@Data
public class RoleInsertDto {
    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色类型 S 系统角色 C 自定义角色
     */
    private String roleType;

    /**
     * 描述
     */
    private String roleDesc;

    /**
     * 角色菜单
     */
    List<String> menuList;

}
