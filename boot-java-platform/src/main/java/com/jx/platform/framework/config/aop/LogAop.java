package com.jx.platform.framework.config.aop;

import com.alibaba.fastjson.JSONObject;
import com.jx.platform.common.request.BodyReaderHttpServletRequestWrapper;
import com.jx.platform.common.request.RequestUtil;
import com.jx.platform.entity.sys.SysActionLog;
import com.jx.platform.framework.security.PlatformUserDetail;
import com.jx.platform.service.sys.SysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @ClassName LLogAspect
 * @Description:
 * @Author: lsz
 * @Date: 2019/11/18 16:45
 * @version: v1.0
 **/
@Component
@Aspect
public class LogAop {

    @Autowired
    private SysService sysService;
    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * 切入点
     */
    @Pointcut("execution (* com.jx.platform..controller..*.*(..))")
    public void controllerAspect() {
    }

    /**
     * 日志输出
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
        String param = new String(new BodyReaderHttpServletRequestWrapper(request).getBody());
        String ip = RequestUtil.getIpAddress(request);
        Long start = System.currentTimeMillis();
        Exception exception = null;
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Exception e) {
            exception = e;
        }
        Long end = System.currentTimeMillis();
        SysActionLog actionLog = new SysActionLog();
        actionLog.setActionUrl(url);
        actionLog.setCostTime(end - start);
        actionLog.setCreateDate(LocalDateTime.now());
        actionLog.setParam(param);
        actionLog.setReqIp(ip);
        actionLog.setApplicationName(applicationName);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if(principal instanceof PlatformUserDetail){
                PlatformUserDetail userDetails = (PlatformUserDetail) authentication.getPrincipal();
                actionLog.setUsername(userDetails.getUsername());
            }else{
                actionLog.setUsername("unkown");
            }

        } else {
            actionLog.setUsername("unkown");
        }
        if(exception==null){
            actionLog.setSuccess("Y");
            actionLog.setResponse(JSONObject.toJSONString(result));
        }else{
            actionLog.setSuccess("N");
            actionLog.setResponse(exception.getClass()+":"+exception.getMessage());
        }

        sysService.insertSysActionLog(actionLog);
        if(exception!=null){
            throw exception;
        }
        return result;
    }

}
