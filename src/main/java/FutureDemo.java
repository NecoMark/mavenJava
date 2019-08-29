import java.util.Timer;
import java.util.concurrent.*;

/**
 * @author: ljyang
 * @date: 2019/6/27 9:05
 * @description
 */
public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> res = executorService.submit(new CallableImp());
        executorService.shutdown();
        try {
            int r = res.get();
            System.out.println(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        FutureTask<Integer> futureTask = new FutureTask<>(new CallableImp());
        Thread t = new Thread(futureTask);
        t.start();
        try {
            int result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

class CallableImp implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 3;
    }
}
