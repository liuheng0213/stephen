package basic.knowledge.stephen.ThreadRelevant._18interruptMethod._01;

public class InterruptionInJava implements Runnable{
    private volatile static boolean on = false;
    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new InterruptionInJava(),"InterruptionInJava");
        //start thread
        testThread.start();
        Thread.sleep(1000);
        InterruptionInJava.on = true;

        System.out.println("main end");

    }

    @Override
    public void run() {
        while(!on){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Yes,I am interruted,but I am still running");
            }else{
                System.out.println("not yet interrupted");
            }
        }
    }
}
