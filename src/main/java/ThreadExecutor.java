import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/**
 * @author: ljyang
 * @date: 2019/6/26 20:37
 * @description
 */
public class ThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorServiceCached = Executors.newCachedThreadPool(); //SynchronousQueue
        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor(); //LinkedBlockingQueue
        ExecutorService executorServiceFixed = Executors.newFixedThreadPool(1); //LinkedBlockingQueue
        ExecutorService executorServiceSchedu = Executors.newScheduledThreadPool(1);
        Executors.defaultThreadFactory();
        ThreadGroup threadGroup = new ThreadGroup("qq");
//        ThreadPoolExecutor
//        CompletableFuture
//        new ThreadPoolExecutor()
//        BlockingQueue
//        Runnable
//        RunnableFuture extends Runnable,Future
//        FutureTask
//        CompletableFuture
//        AbstractOwnableSynchronizer
    }
}
