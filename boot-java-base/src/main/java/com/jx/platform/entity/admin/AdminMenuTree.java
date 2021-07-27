package com.jx.platform.entity.admin;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AdminMenuTree implements Serializable,Comparable<AdminMenuTree> {
    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单级别
     */
    private Integer menuLevel;

    /**
     *
     */
    private String parentMenu;

    /**
     * 菜单顺序
     */
    private Integer menuOrder;

    /**
     * 菜单url
     */
    private String menuUrl;

    /**
     * 是否展示 Y展示 N隐藏
     */
    private String showFlag;

    /**
     * 菜单描述
     */
    private String menuDesc;

    List<AdminMenuTree> children;

    @Override
    public int compareTo(AdminMenuTree o) {
        return this.getMenuOrder()-o.getMenuOrder();
    }
}
