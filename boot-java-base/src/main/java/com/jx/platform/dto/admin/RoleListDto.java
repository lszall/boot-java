package com.jx.platform.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RoleListDto {

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 页码
     */
    @NotNull
    private Integer pageNum;
    /**
     * 每页显示行数
     */
    @NotNull
    private Integer pageSize;
}
