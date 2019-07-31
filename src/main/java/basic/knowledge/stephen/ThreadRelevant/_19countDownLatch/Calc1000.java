package basic.knowledge.stephen.ThreadRelevant._19countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Calc1000 {
    private volatile List<Integer> resList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        Calc1000 calc = new Calc1000();
        int result = calc.calculate();
//        while(true){
//            System.out.println("in");
//            if(result != 500500){
//                System.out.println("wrong");
//                break;
//            }
//        }
        System.out.println(result);
    }

    private int calculate() {
        try {
            ExecutorService fixedThreadPool = Executors. newFixedThreadPool(5);
            CountDownLatch countDownLatch = new CountDownLatch(5);
            fixedThreadPool.execute(new MyThread(1,200,countDownLatch));
            fixedThreadPool.execute(new MyThread(201,400,countDownLatch));
            fixedThreadPool.execute(new MyThread(401,600,countDownLatch));
            fixedThreadPool.execute(new MyThread(601,800,countDownLatch));
            fixedThreadPool.execute(new MyThread(801,1000,countDownLatch));
            countDownLatch.await();

            int sum = 0;
            for(Integer res:resList){
                sum = sum + res;
            }
            return sum;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private class MyThread implements Runnable{
        private int start;
        private int end;
        private CountDownLatch countDownLatch;

        public MyThread(int start, int end, CountDownLatch countDownLatch) {
            this.start = start;
            this.end = end;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ",  begins");
                resList.add(getPartSum(start,end));
                System.out.println(Thread.currentThread().getName() + ",  ends");
            } finally {
                countDownLatch.countDown();
            }
        }

        private int getPartSum(int start, int end) {
            int sum = 0;
            for(int i = start;i<=end;i++){
                sum = sum + i;
            }
            return sum;
        }
    }
}
