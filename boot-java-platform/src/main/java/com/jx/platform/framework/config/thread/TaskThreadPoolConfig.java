package com.jx.platform.framework.config.thread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


@Configuration
public class TaskThreadPoolConfig {


    @Value("${spring.task.execution.pool.core-size:8}")
    private Integer corePoolSize;
    @Value("${spring.task.execution.pool.max-size:16}")
    private Integer maxPoolSize;
    @Value("${spring.task.execution.pool.queue-capacity:20}")
    private Integer queueCapacity;
    @Value("${spring.task.execution.pool.keep-alive:60}")
    private Integer keepAliveSeconds;
    @Value("${spring.task.execution.pool.task-prefix:task-jx}")
    private String taskPrefix;

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        // 空闲的多余线程最大存活时间
        executor.setKeepAliveSeconds(keepAliveSeconds);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(taskPrefix);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
