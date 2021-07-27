package com.jx.platform.framework.config.init;

import com.jx.platform.service.sys.SysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 容器启动时操作写在这里 如果报错将启动失败
 */
@Component
public class PlatformInit implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(PlatformInit.class);
    @Autowired
    private SysService sysService;
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("--------platformInit-------load-dict---");
        sysService.loadDict();

    }



}
