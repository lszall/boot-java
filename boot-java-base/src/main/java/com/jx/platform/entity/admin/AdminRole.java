/**
*
* @ClassName: AdminRole
* @Description: 
* @Author: lsz
* @Date: 2021-07-11 10:16:28
* @version: v1.0
*/
package com.jx.platform.entity.admin;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author lsz
 * @date 2021-07-11 10:16:28
 */
@Table(name = "admin_role")
@Data
public class AdminRole implements GrantedAuthority,Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色类型 S 系统角色 C 自定义角色
     */
    private String roleType;

    /**
     * 描述
     */
    private String roleDesc;

    /**
     * 
     */
    private LocalDateTime createDate;

    private static final long serialVersionUID = 1L;


    @Override
    public String getAuthority() {
        return this.roleCode;
    }
}