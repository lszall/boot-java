package com.jx.platform.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AccountListDto {

    private String account;

    private String phone;

    private String roleCode;

    @NotNull
    private Integer pageNum;
    @NotNull
    private Integer pageSize;
}
