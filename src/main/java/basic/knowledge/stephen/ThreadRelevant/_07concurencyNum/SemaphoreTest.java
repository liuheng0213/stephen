package basic.knowledge.stephen.ThreadRelevant._07concurencyNum;

import java.util.concurrent.Semaphore;

//需求:如何控制某个方法允许并发访问的个数 ,比如 5
public class SemaphoreTest {
    //maxium concurrent numbers: 5
    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test();
                }
            }).start();
        }
    }

    /**
     * 注意acquire是放哪里,防run()里的
     */
    private static void test() {
        try {
            //获取permit,如果semaphore没有可用的permit则等待,有则消耗一个,初始permits 为2
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "conming in");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "going out");
        semaphore.release();
        //如果没有释放这句: 则阻塞
//        Thread-0conming in
//        Thread-1conming in
//        Thread-2conming in
//        Thread-3conming in
//        Thread-4conming in
//        Thread-0going out
//        Thread-1going out
//        Thread-2going out
//        Thread-4going out
//        Thread-3going out
        /**
         * 可知releas的作用是:当前线程运行完以后, 释放掉, 那么可以acqurie新的线程进来运行,保证了并发量为5
         * 如果没这句release()那么就会阻塞, 此时第一波的5个进来了acquire了, 但一直处于这个状态. 那么这5个运行完后, 无法进来新的线程
         */

    }

    /**
     * from the result , i can see that, at the same time ,only 5 threads exists at the same time
     * how many going out, the same number coming in
     * 情况1 : 注释semaphore.acquire()(or plus注释release());由于在coming going 之间有sleep, 那么100条先coming 后 100条going
     * 情况2 : 仅注释release() 则5个come 5个go 且进入阻塞状态
     *        因为有线程进入acuqire会抓到5个线程(并不一定非要release 因为Semaphore定义的时候就有5个)
     *        对于这一点, 比较threadComminication.java 那里定义了Semaphore(0),那么新的permit必须是release的
     *        这里定义了5条说明一开始就有5个,但goout 运行后进入阻塞状态因为没有新的permit了, 没有release嘛
     */
}
