package com.jx.platform.dto.admin;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class MenuListLevelDto {
    @NotNull
    @Min(0)
    @Max(5)
    private Integer menuLevel;

}
