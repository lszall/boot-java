package com.jx.platform.framework.config.exception;

import com.jx.platform.common.exception.BussinessException;
import com.jx.platform.common.response.ResponseData;
import com.jx.platform.common.response.ResponseType;
import io.lettuce.core.RedisConnectionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {


    @ExceptionHandler(value = { BussinessException.class })
    public ResponseData bussinessException(BussinessException ex) {
        ex.printStackTrace();
        ResponseData data = new ResponseData(ResponseType.BUSSINESS_ERROR);
        data.setMsg(ex.getMsg());
        return data;
    }


    /**
     * 404
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { NoHandlerFoundException.class })
    public ResponseData noHandlerFoundException(NoHandlerFoundException ex) {
        ex.printStackTrace();
        ResponseData data = new ResponseData(ResponseType.NOT_FOUND);
        return data;
    }
    @ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
    public ResponseData httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        ResponseData data = new ResponseData(ResponseType.METHOD_ERROR);
        return data;
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseData exception(Exception ex) {
        ex.printStackTrace();
        ResponseData data = new ResponseData(ResponseType.INNER_ERROR);
        data.setDebug(ex.getClass()+":"+ex.getMessage());
        return data;
    }

}
