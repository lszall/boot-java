package com.jx.platform.common.exception;

import lombok.Data;

@Data
public class BussinessException extends RuntimeException {

    private String msg;
    public BussinessException(String msg){
        this.msg = msg;
    }

}
