package basic.knowledge.stephen.ThreadRelevant._06ThreadPool.FixedPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThread {
    public static void main(String[] args) {
        ExecutorService  fixedThreadPool =Executors. newFixedThreadPool(3);
        for (int i =1; i<=10;i++){//开了是个线程 ,但是实际只有三个,其他从线程池里拿着三个
            final int index=i ;
            fixedThreadPool.execute(new Runnable(){//or execute
                @Override
                public void run() {
                    try {
                        System.out.println("第" +index + "个线程" +Thread.currentThread().getName());
                        Thread.sleep(1000);
                    }  catch(InterruptedException  e ) {
                        e .printStackTrace();
                    }
                }

            });
        }
        //关闭线程池
        fixedThreadPool.shutdown();

    }

}


