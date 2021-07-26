package com.jx.platform.dto.admin;

import lombok.Data;

@Data
public class MenuListDto {
    private String menuCode;

    private String menuName;

    private Integer pageNum;

    private Integer pageSize;
}
