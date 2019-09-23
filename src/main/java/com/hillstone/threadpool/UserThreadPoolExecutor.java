package com.hillstone.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ljyang
 * @date: 2019/9/3 22:09
 * @description
 */

public class UserThreadPoolExecutor {
    public static void main(String[] args) {
        Task task = new Task();
        ThreadFactory userThreadFactory = new UserThreadFactory("-demo");
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(2);

        ExecutorService executorService1 = new ThreadPoolExecutor(1,3,60,
                TimeUnit.SECONDS, queue, userThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//        executorService1.submit(task);
//        executorService1.submit(task);
//        executorService1.submit(task);
//        executorService1.
        List<Callable<Boolean>> list = new ArrayList<>();
        for(int i = 0; i< 5; i++){
            list.add(new Task());
        }
        try {
            executorService1.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(queue.peek());


//        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, userThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//        scheduledExecutorService.scheduleAtFixedRate(new Task(), 0L, 1, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();


    }
    static class Task implements Callable{
        private AtomicInteger t = new AtomicInteger(1);
        @Override
        public Boolean call() {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getAndIncrement() + "world");
            return true;
        }
    }

    static class RunnableTask implements Runnable{
        private AtomicInteger t = new AtomicInteger(1);
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getAndIncrement() + "world");
        }
    }
}
