/**
*
* @ClassName: SysActionLog
* @Description: 
* @Author: lsz
* @Date: 2021-07-15 21:44:09
* @version: v1.0
*/
package com.jx.platform.entity.sys;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author lsz
 * @date 2021-07-15 21:44:09
 */
@Table(name = "sys_action_log")
@Data
public class SysActionLog implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String applicationName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 访问地址
     */
    private String actionUrl;

    /**
     * 是否成功
     */
    private String success;

    /**
     * 耗时
     */
    private Long costTime;

    /**
     * 访问IP
     */
    private String reqIp;

    /**
     * 
     */
    private LocalDateTime createDate;

    /**
     * 参数
     */
    private String param;

    /**
     * 返回值
     */
    private String response;

    private static final long serialVersionUID = 1L;


}