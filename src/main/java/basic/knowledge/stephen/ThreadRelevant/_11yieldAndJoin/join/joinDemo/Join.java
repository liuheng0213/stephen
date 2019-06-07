package basic.knowledge.stephen.ThreadRelevant._11yieldAndJoin.join.joinDemo;

import java.util.concurrent.TimeUnit;

public class Join {
    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();//previous为主线程main
        for (int i = 0; i < 10; i++) {
        // 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));//thread的子线程或前驱线程为main,所以一定哟Main执行完先
            thread.start();
            previous = thread;        //这个注释掉就是乱的,仅仅保证了main的打印语句第一个执行
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }
    static class Domino implements Runnable {
        private Thread thread;
        public Domino(Thread thread) {
            this.thread = thread;
        }
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
/**
 * 从上述输出可以看到，每个线程终止的前提是前驱线程的终止，每个线程等待前驱线程
 终止后，才从join()方法返回，这里涉及了等待/通知机制（等待前驱线程结束，接收前驱线程结
 束通知）。
 代码流程: 十个循环依次开启,main是thread0的前驱,thread0是thread1的前驱...依以此类推
开启后由于run中为thread.join();所以得先运行前驱线程的System.out.println(Thread.currentThread().getName() + " terminate.");

 */
