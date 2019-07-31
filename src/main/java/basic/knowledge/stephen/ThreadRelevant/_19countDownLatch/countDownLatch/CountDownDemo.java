package basic.knowledge.stephen.ThreadRelevant._19countDownLatch.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownDemo {

    public static void main(String[] args) {
        try {
            Service service = new Service();
            CountDownLatch begin = new CountDownLatch(1);//裁判员鸣枪信号
            CountDownLatch end = new CountDownLatch(10);//10名参赛选手结束信号
            MyThread[] threadArray = new MyThread[10];
            for(int i = 0 ; i < 10; i++){
                threadArray[i] = new MyThread(service,begin,end);
                threadArray[i].setName((i + 1) + " 号选手 ");
                threadArray[i].start();
            }
            System.out.println("在等待裁判员鸣枪  " + System.currentTimeMillis());
            long t1 = System.currentTimeMillis();//记录比赛的开始时间
            begin.countDown();//裁判员鸣枪了
            end.await();//等待10个参赛选手都跑完100米
            long t2 = System.currentTimeMillis();//记录比赛的结束时间
            System.out.println("所有参赛选手都完成了100米赛跑，赛跑总耗时是  " + (t2-t1));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

