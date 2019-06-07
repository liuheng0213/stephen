package basic.knowledge.stephen.ThreadRelevant._06ThreadPool.cachedThreadPool.mockOOM;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * JDK5.0以后每个线程堆栈大小为1M
 *
 */
public class newCachedThreadPoolTest {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i < 10000; i++)
            executorService.submit(new task());

    }

}

class task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
