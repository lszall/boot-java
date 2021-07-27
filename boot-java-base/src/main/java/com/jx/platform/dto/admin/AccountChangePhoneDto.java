package com.jx.platform.dto.admin;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class AccountChangePhoneDto {
    @NotBlank
    @Length(max = 11)
    private String phone;
    @NotBlank
    private String password;
}
