package basic.knowledge.stephen.ThreadRelevant._11yieldAndJoin.join;

public class Thread1 extends Thread {
    public Thread1() {
        super("[Thread1] Thread");
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");//[Thread1] Thread start.
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + " end.");//[Thread1] Thread end.
        } catch (Exception e) {
            System.out.println("exception from " + threadName + ".run");
        }


    }
}
