package basic.knowledge.stephen.ThreadRelevant._10deadLockAndFindIt;


import basic.knowledge.stephen.ThreadRelevant._10deadLockAndFindIt.UtilDeadLockCheckOut.DeadlockConsoleHandler;
import basic.knowledge.stephen.ThreadRelevant._10deadLockAndFindIt.UtilDeadLockCheckOut.DeadlockDetector;

import java.util.concurrent.TimeUnit;

/**
 * 可以看到运行时，一个线程持有A资源，
 * 希望使用B资源，而另一个线程持有B资源，
 * 希望使用A 资源，然后就陷入了相互等待的僵局，
 * 这样就形成了死锁。
 * cmd  运行jconsole可以看到死锁情况
 */
public class Test {

    public static void main(String[] args) {
        DeadlockDetector deadlockDetector = new DeadlockDetector(new DeadlockConsoleHandler(), 5, TimeUnit.SECONDS);
        deadlockDetector.start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (B.class) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A.class) {

                    }
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (A.class) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    synchronized (B.class) {

                    }
                }

            }
        }).start();
    }

}
class A {

}
class B {

}
