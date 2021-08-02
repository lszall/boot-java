/**
*
* @ClassName: SysUpload
* @Description: 
* @Author: lsz
* @Date: 2021-08-02 21:38:26
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
 * @date 2021-08-02 21:38:26
 */
@Table(name = "sys_upload")
@Data
public class SysUpload implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 用处
     */
    private String location;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 类型 P 图片 E excel W word T txt 
     */
    private String fileType;

    /**
     * 原始文件名
     */
    private String originName;

    /**
     * 
     */
    private LocalDateTime createDate;

    private static final long serialVersionUID = 1L;

}