package com.jx.platform.framework.base;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.common.response.ResponseType;
import com.jx.platform.framework.security.PlatformUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 */
public class BaseController {

    /**
     * 获取用户登录信息
     *
     * @return
     */
    public PlatformUserDetail userDetail() {
        PlatformUserDetail userDetails = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null&&authentication.getPrincipal() instanceof PlatformUserDetail) {
            userDetails = (PlatformUserDetail) authentication.getPrincipal();
        }
        return userDetails;
    }
    /**
     * 成功返回
     * @return
     */
    public ResponseData success(){
        return new ResponseData();
    }
    /**
     * 成功返回
     * @param data
     * @return
     */
    public ResponseData success(Object data){
        return new ResponseData(data);
    }
    /**
     * 失败返回
     * @param msg
     * @return
     */
    public ResponseData failure(String msg){
        ResponseData data= new ResponseData(ResponseType.BUSSINESS_ERROR);
        data.setMsg(msg);
        return data;
    }
}
