package basic.knowledge.stephen.ThreadRelevant._11yieldAndJoin.join;

public class Thread2 extends Thread {
    Thread1 t1;

    public Thread2(Thread1 thread1) {
        super("[Thread2] Thread");
        this.t1 = thread1;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");  //[Thread2] Thread start
        try {
            t1.join();
            System.out.println(threadName + " end.");//[Thread2] Thread end.
        } catch (Exception e) {
            System.out.println("exception from" + threadName + ".run");
        }


    }
}
