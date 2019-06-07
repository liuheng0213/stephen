package basic.knowledge.stephen.ThreadRelevant._19countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * https://cloud.tencent.com/developer/article/1038486
 1 首先是创建实例 CountDownLatch countDown = new CountDownLatch(2)
 2 需要同步的线程执行完之后，计数-1； countDown.countDown()
 3 需要等待其他线程执行完毕之后(减到0后)，再运行的线程，调用 countDown.await()实现阻塞同步
 */
public class CountDownLatchDemo {
    private CountDownLatch countDownLatch;

    private int start = 10;
    private int mid = 100;
    private int end = 200;

    private volatile int tmpRes1, tmpRes2;

    private int add(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }


    private int sum(int a, int b) {
        return a + b;
    }

    public void calculate() {
        countDownLatch = new CountDownLatch(2);//填3就会阻塞

        Thread thread1 = new Thread(() -> {
            try {
                // 确保线程3先与1，2执行，由于countDownLatch计数不为0而阻塞
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : 开始执行");
                tmpRes1 = add(start, mid);
                System.out.println(Thread.currentThread().getName() +
                        " : calculate ans: " + tmpRes1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }, "线程1");

        Thread thread2 = new Thread(() -> {
            try {
                // 确保线程3先与1，2执行，由于countDownLatch计数不为0而阻塞
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : 开始执行");
                tmpRes2 = add(mid + 1, end);
                System.out.println(Thread.currentThread().getName() +
                        " : calculate ans: " + tmpRes2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }, "线程2");


        Thread thread3 = new Thread(()-> {
            try {
                System.out.println(Thread.currentThread().getName() + " : 开始执行");
                countDownLatch.await(1000, TimeUnit.MILLISECONDS);//只有在countdown到0时  会启动,//和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
                int ans = sum(tmpRes1, tmpRes2);
                System.out.println(Thread.currentThread().getName() +
                        " : calculate ans: " + ans);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程3");

        thread3.start();
        thread1.start();
        thread2.start();
    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        demo.calculate();

        Thread.sleep(1000);
    }
}
/**
 在创建实例是，必须指定初始的计数值，且应大于0
 必须有线程中显示的调用了countDown()计数-1方法；必须有线程显示调用了 await()方法（没有这个就没有必要使用CountDownLatch了）
 由于await()方法会阻塞到计数为0，如果在代码逻辑中某个线程漏掉了计数-1，导致最终计数一直大于0，直接导致死锁了
 鉴于上面一点，更多的推荐 await(long, TimeUnit)来替代直接使用await()方法，至少不会造成阻塞死只能重启的情况
 */
