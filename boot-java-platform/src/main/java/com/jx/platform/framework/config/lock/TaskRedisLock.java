package com.jx.platform.framework.config.lock;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class TaskRedisLock {

    private static final Logger log = LoggerFactory.getLogger(TaskRedisLock.class);

    /**
     * redis key 失效监听处理 锁
     */
    private static final String KEY_EXPIRE_HANDLE_KEY = "KEY_EXPIRE_HANDLE::";
    /**
     * redis key 失效监听处理 锁 失效时间60秒
     */
    private static final long KEY_EXPIRE_HANDLE_EXPIRE = 60000L;

    @Autowired
    private RedisTemplate redisTemplate;

    public String getLock(String lockKey, long expire) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Boolean result = redisTemplate.opsForValue().setIfAbsent(lockKey, uuid, expire, TimeUnit.MILLISECONDS);
        return result ? uuid : null;
    }

    public void unLock(String lockKey, String uuid) {
        String lock = redisTemplate.opsForValue().get(lockKey).toString();
        if (uuid.equals(lock)) {
            redisTemplate.delete(lockKey);
        }
    }

    /**
     * 处理 @TaskLock 任务
     * @param lockKey
     * @param expire
     * @param callback
     * @return
     * @throws Throwable
     */
    public Object doTaskInLock(String lockKey, long expire, CallBack callback) throws Throwable {
        Object result = null;
        String lock = null;
        try {
            lock = getLock(lockKey, expire);
            if (lock != null) {
                result = callback.doTask();
            }
        } catch (Throwable e) {
            log.error("-----处理失败---");
            throw e;
        } finally {
            if (StringUtils.isNotBlank(lock)) {
                unLock(lockKey, lock);
            }
        }
        return result;
    }


    /**
     * redis key 失效处理
     * @param expiredKey
     */
    public void keyExpireHandle(String expiredKey){
        log.info("handle expire key :" + expiredKey);
        String lock = null;
        String lockKey = KEY_EXPIRE_HANDLE_KEY + expiredKey;
        try {
            lock = getLock(lockKey, KEY_EXPIRE_HANDLE_EXPIRE);
            if (lock != null) {
                log.info("TODO 实际处理方法 做一个分发 :" + expiredKey);
            }
        } catch (Throwable e) {
            log.error("-----处理失败---");
            throw e;
        } finally {
            if (StringUtils.isNotBlank(lock)) {
                unLock(lockKey, lock);
            }
        }


    }

}
