package basic.knowledge.stephen.ThreadRelevant._20cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class Client  {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () ->
                System.out.println("人满了发车")
        );

        IntStream.range(1, 11).forEach(number -> {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Thread(() -> {
                try {
                    System.out.println("第 " + number + " 乘客上车了！");
                    cyclicBarrier.await();
                    System.out.println("第 " + number + " 乘客出发了！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }
}
