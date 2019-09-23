import java.util.ArrayList;
import java.util.List;
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
//        AbstractOwnableSynchronizer\
        List l1 = new ArrayList();
        l1.add("11");
        l1.add(22);
        List<String> l2 = l1;
        l2.add("44");
        List<?> l3 = l1;
        Class<?> c = Integer.class;
        System.out.println(c);
        System.out.println(l1.toString());
        System.out.println(l2.toString());
    }
}
