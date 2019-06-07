package basic.knowledge.stephen.ThreadRelevant._18interruptMethod._02;

/**
 * 线程被阻塞无法被中断。这时候救世主interrupt函数又回来了，
 * 它可以迅速中断被阻塞的线程，抛出一个InterruptedException，把线程从阻塞状态中解救出来
 */
public class InterruptionInJava implements Runnable{
    private volatile static boolean on = false;
    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new InterruptionInJava(),"InterruptionInJava");
        //start thread
        testThread.start();
        Thread.sleep(2000);
        InterruptionInJava.on = true;
        testThread.interrupt();

        System.out.println("main end");

    }

    @Override
    public void run() {
        while(!on){
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                System.out.println("caught exception right now: "+e);
            }
        }
    }
}
