package com.jx.platform.dto.admin;

import lombok.Data;

@Data
public class RoleListDto {

    private String roleCode;

    private String roleName;

    private Integer pageNum;

    private Integer pageSize;
}
