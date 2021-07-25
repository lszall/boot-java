package com.jx.platform.common.response;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
    private static final Logger log = LoggerFactory.getLogger(ResponseUtil.class);
    public static void writeJson(HttpServletResponse response,ResponseData data){
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(JSONObject.toJSONString(data));
        } catch (IOException e) {
            log.error("response write error");
        }

    }
}
