package basic.knowledge.stephen.ThreadRelevant._09ReentrantReadWriteLock.readWriteLock;

import java.util.Random;

public class MainReadWritLockTest {

    public static void main(String[] args) {

        final Queue queue = new Queue();

        for(int i=0; i<5;i++){      //创建5个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.get();
                }
            }).start();
        }

        for(int i=0; i<2;i++){      //创建2个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.put(new Random().nextInt(10000));
                }
            }).start();
        }
    }
}
