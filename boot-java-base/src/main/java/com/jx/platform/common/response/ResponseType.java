package com.jx.platform.common.response;

/**
 * @ClassName ResponseType
 * @Description:
 * @Author: lsz
 * @Date: 2019/12/16 17:02
 * @version: v1.0
 **/
public enum ResponseType {

    SUCCESS(1001, "success!"),
    AUTH_ERROR(1002, "请出示正确的令牌!"),
    NOT_FOUND(1003, "你的导航不正确，迷路了!"),
    METHOD_ERROR(1004, "请求方式不正确,换个姿势再来一次."),
    PARAM_ERROR(1005, "参数格式不正确!"),
    PARAM_TYPE_ERROR(1006, "参数类型不正确!"),
    INNER_ERROR(9999, "Oh No! 服务器崩溃了，请休息一下。"),
    BUSSINESS_ERROR(1008, "逻辑错误!");


    private int code;

    private String msg;

    ResponseType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }
}
