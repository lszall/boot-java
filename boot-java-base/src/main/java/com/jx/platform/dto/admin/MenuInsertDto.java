package com.jx.platform.dto.admin;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MenuInsertDto {
    /**
     * 菜单编码
     */
    @NotBlank
    @Length(max = 50)
    private String menuCode;

    /**
     * 菜单名称
     */
    @NotBlank
    @Length(max = 50)
    private String menuName;

    /**
     * 菜单级别
     */
    @NotNull
    private Integer menuLevel;

    /**
     *
     */
    @NotBlank
    @Length(max = 50)
    private String parentMenu;

    /**
     * 菜单顺序
     */
    @NotNull
    private Integer menuOrder;

    /**
     * 菜单url
     */
    @NotNull
    @Length(max = 255)
    private String menuUrl;

    /**
     * 是否展示 Y展示 N隐藏
     */
    @NotBlank
    @Length(min = 1,max = 1)
    private String showFlag;

    /**
     * 菜单描述
     */
    @Length(max = 100)
    private String menuDesc;
}
