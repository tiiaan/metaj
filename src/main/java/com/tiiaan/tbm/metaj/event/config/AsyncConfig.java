package com.tiiaan.tbm.metaj.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Configuration
public class AsyncConfig {

    private static final int CORE_POOL_SIZE = 10;
    private static final int MAXIMUM_POOL_SIZE_SIZE = 20;
    private static final int KEEP_ALIVE_TIME_SECONDS = 60;
    private static final int BLOCKING_QUEUE_CAPACITY = 20;
    private static final int AWAIT_TERMINATION_SECONDS = 60;


    @Bean("issueTaskExecutor")
    public AsyncTaskExecutor issueTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAXIMUM_POOL_SIZE_SIZE);
        taskExecutor.setQueueCapacity(BLOCKING_QUEUE_CAPACITY);
        taskExecutor.setKeepAliveSeconds(KEEP_ALIVE_TIME_SECONDS);
        taskExecutor.setThreadNamePrefix("issue-task-");
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); //采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在execute方法的调用线程中运行被拒绝的任务；如果执行程序已被关闭，则会丢弃该任务
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true); //线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        taskExecutor.setAwaitTerminationSeconds(AWAIT_TERMINATION_SECONDS); //线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住
        return taskExecutor;

        //ExecutorService threadPool = new ThreadPoolExecutor(
        //        CORE_POOL_SIZE,
        //        MAXIMUM_POOL_SIZE_SIZE,
        //        KEEP_ALIVE_TIME,
        //        TimeUnit.SECONDS,
        //        new LinkedBlockingQueue<Runnable>(BLOCKING_QUEUE_CAPACITY),
        //        Executors.defaultThreadFactory(),
        //        new ThreadPoolExecutor.AbortPolicy())
    }

}
