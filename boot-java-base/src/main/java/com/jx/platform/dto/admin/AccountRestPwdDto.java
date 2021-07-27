package com.jx.platform.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountRestPwdDto {
    @NotBlank
    private String account;
    private String password;
}
