package basic.knowledge.stephen.ThreadRelevant._06ThreadPool.threadPoolPrinciple;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * newFixedThreadPool事例
 1、创建的线程池具体配置为：核心线程数量为5个；全部线程数量为10个；工作队列的长度为5。
 2、我们通过queue.size()的方法来获取工作队列中的任务数。
 3、运行原理：
 1 刚开始都是在创建新的线程，达到核心线程数量5个后，新的任务进来后不再创建新的线程，
 2 而是将任务加入工作队列，任务队列到达上线5个后，
 3 新的任务又会创建新的普通线程，直到达到线程池最大的线程数量10个，后面的任务则根据配置的饱和策略来处理。
 我们这里没有具体配置，使用的是默认的配置AbortPolicy:直接抛出异常。
 当然，为了达到我需要的效果，上述线程处理的任务都是利用休眠导致线程没有释放！！！
 */
public class ThreadPoolTest implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue =
                new LinkedBlockingQueue<Runnable>(5);//这是适用于newFixedThreadPool()的
        ThreadPoolExecutor threadPool =
                new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, queue);
        for (int i = 0; i < 16; i++) {
            threadPool.execute(new ThreadPoolTest());
            System.out.println("线程池中活跃的线程数： " + threadPool.getPoolSize());
            if (queue.size() > 0) {
                System.out.println("----------------队列中阻塞的线程数" + queue.size());
            }
        }
        threadPool.shutdown();
    }
}
