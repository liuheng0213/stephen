package basic.knowledge.stephen.ThreadRelevant._20cyclicBarrier;

import java.util.LinkedHashSet;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Client  {
    public static void main(String[] args) {

        AtomicReference<CyclicBarrier> cyclicBarrier = new AtomicReference<>(new CyclicBarrier(2, () ->
                System.out.println("人满了发车")
        ));

        IntStream.range(1, 12).forEach(number -> {
           /* try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            if(number == 11){
                cyclicBarrier.set(new CyclicBarrier(1));
            }
            new Thread(() -> {
                try {
                    System.out.println("第 " + number + " 乘客上车了！");
                    cyclicBarrier.get().await();
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
