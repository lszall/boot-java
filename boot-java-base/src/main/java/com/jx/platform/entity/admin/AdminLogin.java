/**
*
* @ClassName: AdminLogin
* @Description: 
* @Author: lsz
* @Date: 2021-07-11 10:16:28
* @version: v1.0
*/
package com.jx.platform.entity.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author lsz
 * @date 2021-07-11 10:16:28
 */
@Table(name = "admin_login")
@Data
public class AdminLogin implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 
     */
    private String roleCode;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 状态 Y启用  N禁用
     */
    private String status;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    private static final long serialVersionUID = 1L;

}