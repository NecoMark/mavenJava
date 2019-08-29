import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: ljyang
 * @date: 2019/6/22 14:49
 * @description
 */
public class MyThread {
    public static void main(String[] args) {
//        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
//        cyclicBarrierDemo.execute();
//        ConditionDemo conditionDemo = new ConditionDemo();
//        conditionDemo.execute();
        SynchronizeObject synchronizeObject = new SynchronizeObject();
        synchronizeObject.execute();
        List<Object> listObject = new ArrayList<>();
        listObject.add("ddd");
        List<String> list = null;

        try {
            list = (List) listObject;
            System.out.println("ddd");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(list.toString());

    }
//    private
}


class CyclicBarrierDemo{
    public void execute(){
        //所有线程释放barrier后 仍可重新使用
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                cyclicBarrier.await();
                System.out.println("t1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            System.out.println("at2");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("t2");
        });
        t1.start();
        t2.start();
    }
}


class CountDownLatchDemo{
    //coundownlatch只能使用一次
    public void execute(){
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");
        });

        t1.start();
        t2.start();
    }
}


class SemaphoreDemo implements Execute{
    @Override
    public void execute(){
        //最多有两个线程执行
        Semaphore semaphore = new Semaphore(2);

    }
}


class ConditionDemo implements Execute{
//    static int count = 0;
    AtomicLong count = new AtomicLong(0L);
    @Override
    public void execute(){
        ReentrantLock reentrantLock = new ReentrantLock();
        final Condition fullCondition = reentrantLock.newCondition();
        final Condition emptyCondition = reentrantLock.newCondition();
        Queue queue = new ArrayDeque();
        Thread t1 = new Thread(() -> {
            while(true){
                try {
                    reentrantLock.lock();
                    while (10 == queue.size()){
                        try {
                            fullCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(count.getAndIncrement());
                    emptyCondition.signalAll();
                } finally {
                    reentrantLock.unlock();
                }
            }

        });

        Thread t2 = new Thread(() -> {
            while (true){

                try {
                    reentrantLock.lock();
                    while(0 == queue.size()){
                        try {
                            emptyCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                    ((ArrayDeque) queue).pollFirst();
                    System.out.println("t2  " + String.valueOf(((ArrayDeque) queue).pollFirst()));
                    fullCondition.signalAll();
                } finally {
                    reentrantLock.unlock();
                }
            }

        });

        Thread t3 = new Thread(() -> {
            while(true){
                try {
                    reentrantLock.lock();
                    while(0 == queue.size()){
                        try {
                            emptyCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                    ((ArrayDeque) queue).pollFirst();
                    System.out.println("t3  " + String.valueOf(((ArrayDeque) queue).pollFirst()));
                    fullCondition.signalAll();
                } finally {
                    reentrantLock.unlock();
                }
            }

        });

        t1.start();
        t2.start();
        t3.start();
    }
}


class SynchronizeObject implements Execute{
    Object object1 = new Object();
//    AbstractExecutorService
//    ForkJoinPool
//    ScheduledExecutorService
//    ThreadPoolExecutor
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    AtomicLong atomicLong = new AtomicLong(0);

    ExecutorService threadPoolExecutor = new ThreadPoolExecutor()

    @Override
    public void execute() {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (object1){
                        while(atomicLong.get() > 10){
                            try {
                                object1.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        atomicLong.getAndIncrement();
                        System.out.println(atomicLong.toString());
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        object1.notifyAll();
                    }
                }

            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (object1){
                        while(atomicLong.get() <= 10){
                            try {
                                object1.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        atomicLong.getAndDecrement();
                        object1.notifyAll();
                    }
                }

            }
        });
        executorService.shutdown();

    }
}

interface Execute{
    void execute();
}
//f6503761ff5528694cb510f1719a8972
//d0f5686e1c4ff7a8902679c583c41404


abstract class AbstractExecute implements Execute{

}