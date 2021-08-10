package com.jx.platform.framework.config.aop;

import com.jx.platform.framework.config.lock.TaskRedisLock;
import com.jx.platform.framework.config.lock.annotation.TaskLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RedisLockAop {


    @Autowired
    private TaskRedisLock taskRedisLock;

    /**
     * 切入点
     */
    @Pointcut("execution (* com.jx.platform.application..service..*.*(..))")
    public void controllerAspect() {
    }

    /**
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("controllerAspect()&&@annotation(taskLock)")
    public Object around(ProceedingJoinPoint pjp, TaskLock taskLock) throws Throwable {
        long expire = taskLock.expire();
        String lockKey = taskLock.lockKey();
        return taskRedisLock.doTaskInLock(lockKey, expire, pjp::proceed);
    }
}
