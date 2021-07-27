package com.jx.platform.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RoleListDto {

    private String roleCode;

    private String roleName;

    @NotNull
    private Integer pageNum;
    @NotNull
    private Integer pageSize;
}
