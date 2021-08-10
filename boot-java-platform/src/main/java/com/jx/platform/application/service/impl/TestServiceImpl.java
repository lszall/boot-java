package com.jx.platform.application.service.impl;

import com.jx.platform.application.service.TestService;
import com.jx.platform.framework.config.lock.annotation.TaskLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService {
    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    @Override
    @Async
    public void ss() {

        for (int i = 0; i <100 ; i++) {
            log.info("---"+i);
        }
    }

    @Override
    @Async
    public void aa(int x) {
        log.info("---"+x);
    }

    @Override
    @Async
    public void aas(int x) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("---"+x);
    }

    @Override
    @TaskLock(lockKey = "TAKS-TEST",expire = 2000L)
    public String task() {
        log.info("--执行--");
        try {
            Thread.sleep(100);
            return "success";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "failure";
    }
}
