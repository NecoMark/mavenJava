package com.hillstone.threadpool;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author: ljyang
 * @date: 2019/9/3 22:09
 * @description
 */

public class UserThreadPoolExecutor {
    public static void main(String[] args) {
        Task task = new Task();
        ThreadFactory userThreadFactory = new UserThreadFactory("-demo");
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(1);

        ExecutorService executorService1 = new ThreadPoolExecutor(1,3,60, TimeUnit.SECONDS, queue, userThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        executorService1.submit(task);
        executorService1.submit(task);
        executorService1.submit(task);
        executorService1.shutdown();
        System.out.println(queue.peek());


//        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, userThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//        scheduledExecutorService.scheduleAtFixedRate(new Task(), 0L, 1, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();


    }
    static class Task implements Runnable{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("world");
        }
    }
}
