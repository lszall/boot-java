/**
*
* @ClassName: SysDictType
* @Description: 
* @Author: lsz
* @Date: 2021-07-25 09:52:27
* @version: v1.0
*/
package com.jx.platform.entity.sys;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * 
 *
 * @author lsz
 * @date 2021-07-25 09:52:27
 */
@Table(name = "sys_dict_type")
public class SysDictType implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String typeCode;

    /**
     * 
     */
    private String typeName;

    /**
     * 
     */
    private String desc;

    private static final long serialVersionUID = 1L;

    //获取:
    public Integer getId() {
        return id;
    }

    //设置:
    public void setId(Integer id) {
        this.id = id;
    }

    //获取:
    public String getTypeCode() {
        return typeCode;
    }

    //设置:
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    //获取:
    public String getTypeName() {
        return typeName;
    }

    //设置:
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    //获取:
    public String getDesc() {
        return desc;
    }

    //设置:
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
	* 
	* 
	* @return java.lang.String
	* @author lsz
	* @date 2021-07-25 09:52:27
	*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", typeCode=").append(typeCode);
        sb.append(", typeName=").append(typeName);
        sb.append(", desc=").append(desc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}