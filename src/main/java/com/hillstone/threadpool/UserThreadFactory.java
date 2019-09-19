package com.hillstone.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ljyang
 * @date: 2019/9/3 21:19
 * @description
 */

public class UserThreadFactory implements ThreadFactory {
    private String factoryName;
    private AtomicInteger id = new AtomicInteger(1);
    /**
        threadGroup的父线程组为当前线程组
     */
    private ThreadGroup threadGroup = new ThreadGroup("hillstone");

    public UserThreadFactory(String factoryName) {
        this.factoryName = "UserThreadFactory: " + factoryName + "-";
    }

    @Override
    public Thread newThread(Runnable r) {
        String threadName = this.factoryName + String.valueOf(id.getAndIncrement());

        Thread thread = new Thread(threadGroup, r, threadName, 0);
        System.out.println(thread.getName());
        return thread;
    }

}
