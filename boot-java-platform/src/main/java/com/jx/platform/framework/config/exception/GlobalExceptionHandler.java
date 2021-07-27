package com.jx.platform.framework.config.exception;

import com.jx.platform.common.exception.BussinessException;
import com.jx.platform.common.response.ResponseData;
import com.jx.platform.common.response.ResponseType;
import io.lettuce.core.RedisConnectionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理器（controller 层面捕获） （无法捕获SpringSecurity过滤链产生的异常）
 */
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {


    /**
     * 业务逻辑错误
     * @param ex
     * @return
     */
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

    /**
     * 请求方式不正确
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
    public ResponseData httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        ResponseData data = new ResponseData(ResponseType.METHOD_ERROR);
        return data;
    }

    /**
     * 校验失败
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseData methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ResponseData data = new ResponseData(ResponseType.PARAM_ERROR);
        data.setMsg(ex.getMessage());
        return data;
    }

    /**
     * JSON 格式不正确
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { HttpMessageNotReadableException.class })
    public ResponseData httpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ResponseData data = new ResponseData(ResponseType.PARAM_ERROR);
        data.setMsg(ex.getMessage());
        return data;
    }

    /**
     * 500
     * 其他错误
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { Exception.class })
    public ResponseData exception(Exception ex) {
        ex.printStackTrace();
        ResponseData data = new ResponseData(ResponseType.INNER_ERROR);
        data.setDebug(ex.getClass()+":"+ex.getMessage());
        return data;
    }

}
