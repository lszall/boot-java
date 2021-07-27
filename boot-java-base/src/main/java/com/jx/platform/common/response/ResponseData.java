package com.jx.platform.common.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName ResponseEntiy
 * @Description: 统一返回值类型
 * @Author: lsz
 * @Date: 2019/12/16 16:59
 * @version: v1.0
 **/
@Data
public class ResponseData implements Serializable {

    /**
     * 返回代码 详见ResponseType 枚举
     */
    private Integer code;

    /**
     * 返回附加信息
     */
    private String msg;
    /**
     * 返回时间
     */
    private LocalDateTime time;

    /**
     * 报错信息
     */
    private String debug;

    /**
     * 返回数据
     */
    private Object data;


    public ResponseData(ResponseType type) {
        this.code = type.code();
        this.msg = type.msg();
        this.time = LocalDateTime.now();
    }

    public ResponseData() {
        this(ResponseType.SUCCESS);
    }

    public ResponseData(Object object) {
        this(ResponseType.SUCCESS);
        this.setData(object);
    }


    public void setCode(ResponseType type) {
        this.code = type.code();
        this.msg = type.msg();
    }



}
