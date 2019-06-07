package basic.knowledge.stephen.ThreadRelevant._06ThreadPool.cachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，
 * 若无可回收，则新建线程。
 *
 * 线程池为无限大，当执行第二个任务时第一个任务已经完成(无sleep)，
 * 会复用执行第一个任务的线程，而不用每次新建线程。
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService cacheThreadPool =Executors.newCachedThreadPool();
        for(int i =1;i<=15;i++){
            final int index=i ;
            try{
                Thread.sleep(100);
            }catch(InterruptedException  e ) {
                e.printStackTrace();
            }
            cacheThreadPool.execute(new Runnable(){
                @Override
                public void run() {
                    //下面的try.catch是否去掉
                    //所以所谓的小程序适合,即每个线程短时间执行完毕的,适合,否则容易报OOM
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第" +index +"个线程" +Thread.currentThread().getName());
                }
            });
        }
        cacheThreadPool.shutdown();
    }
}