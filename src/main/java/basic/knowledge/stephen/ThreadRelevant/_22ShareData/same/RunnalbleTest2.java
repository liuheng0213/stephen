package basic.knowledge.stephen.ThreadRelevant._22ShareData.same;

public class RunnalbleTest2 implements Runnable {
    private int threadCnt = 10;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (threadCnt > 0) {
                    System.out.println(Thread.currentThread().getName() + " 剩余个数 " + threadCnt);
                    threadCnt--;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        RunnalbleTest2 runnalbleTest2 = new RunnalbleTest2();
        new Thread(runnalbleTest2).start();
        new Thread(runnalbleTest2).start();
    }
}
