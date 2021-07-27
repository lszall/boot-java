package com.jx.platform.dto.admin;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class RoleInsertDto {
    /**
     * 角色编码
     */
    @NotBlank
    @Length(max = 50)
    private String roleCode;

    /**
     * 角色名称
     */
    @NotBlank
    @Length(max = 50)
    private String roleName;

    /**
     * 角色类型 S 系统角色 C 自定义角色
     */
    private String roleType;

    /**
     * 描述
     */
    @Length(max = 255)
    private String roleDesc;

    /**
     * 角色菜单
     */
    @NotEmpty
    List<String> menuList;

}
