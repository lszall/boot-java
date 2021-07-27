package com.jx.platform.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountRestPasswordDto {
    @NotBlank
    private String oldPassword;
    @NotBlank
    private String newPassword;

}
