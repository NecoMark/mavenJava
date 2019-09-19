package com.hillstone.threadpool;

import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: ljyang
 * @date: 2019/9/3 22:11
 * @description
 */

public class RejectedExecutionExceptionFactory {
    private static class UserRejectedHandler implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        }
    }
}
