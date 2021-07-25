package com.jx.platform.framework.config.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * redis Key过期处理监听器
 * 修改配置文件redis.conf中的：notify-keyspace-events Ex，默认为notify-keyspace-events ""， 查看“notify-keyspace-events”的配置项，如果没有，添加“notify-keyspace-events Ex”，如果有值，添加Ex，
 */
@Component
public class RedisExpiredListener extends KeyExpirationEventMessageListener {
    private static final Logger log = LoggerFactory.getLogger(RedisExpiredListener.class);

    /**
     * Creates new {@link MessageListener} for {@code __keyevent@*__:expired} messages.
     *
     * @param listenerContainer must not be {@literal null}.
     */
    public RedisExpiredListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }



    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        String expiredKey = message.toString();
        log.info("redis-key-expireKey:" + expiredKey);
        log.info("redis-key-pattern:" + new String(pattern));
    }
}
