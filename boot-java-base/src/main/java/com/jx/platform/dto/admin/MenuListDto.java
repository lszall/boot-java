package com.jx.platform.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MenuListDto {
    private String menuCode;

    private String menuName;

    @NotNull
    private Integer pageNum;
    @NotNull
    private Integer pageSize;
}
