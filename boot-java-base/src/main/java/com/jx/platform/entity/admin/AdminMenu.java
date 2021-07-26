/**
*
* @ClassName: AdminMenu
* @Description: 
* @Author: lsz
* @Date: 2021-07-26 15:04:39
* @version: v1.0
*/
package com.jx.platform.entity.admin;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author lsz
 * @date 2021-07-26 15:04:39
 */
@Table(name = "admin_menu")
@Data
public class AdminMenu implements Serializable {
    /**
     *
     */
    private Integer id;

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

    /**
     * 
     */
    private LocalDateTime createDate;

    private static final long serialVersionUID = 1L;

}