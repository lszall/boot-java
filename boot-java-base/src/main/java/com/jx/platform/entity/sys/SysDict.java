/**
*
* @ClassName: SysDict
* @Description: 
* @Author: lsz
* @Date: 2021-07-25 09:52:27
* @version: v1.0
*/
package com.jx.platform.entity.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * 
 *
 * @author lsz
 * @date 2021-07-25 09:52:27
 */
@Table(name = "sys_dict")
@Data
public class SysDict implements Serializable {
    /**
     * id
     */
    @JsonIgnore
    private Integer id;

    /**
     * 字典类型代码
     */
    private String typeCode;

    /**
     * 字典码
     */
    private String code;

    /**
     * 字典显示名称
     */
    private String name;

    private static final long serialVersionUID = 1L;

}