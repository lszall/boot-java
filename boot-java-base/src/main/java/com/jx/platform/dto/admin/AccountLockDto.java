package com.jx.platform.dto.admin;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class AccountLockDto {
    @NotBlank
    @Length(min = 1,max = 1)
    private String lock;
    @NotBlank
    private String account;
}
