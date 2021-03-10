package basic.knowledge.stephen.ThreadRelevant._08semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Client {
    public static void main(String[] args) {
        //用于生成随机停车时长
        Random random = new Random();
        //用Semaphore模拟有10个停车位的停车场管理系统
        final Semaphore parkingSystem = new Semaphore(10);

        //模拟500辆汽车来停车
        IntStream.range(0,500).forEach(i->{
            new Thread(()->{
                //取得到达停车场的时间
                Long startWaitTime = System.currentTimeMillis();
                System.out.println("第"+(i+1)+"辆汽车来到车库");

                //等待停车场系统控制抬杆。如果还有空位，立即抬杆，否则一直等到有空位才抬杆
                try {
                    //acquire方法用于获取资源，这里模拟发出抬杆放行的请求
                    parkingSystem.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //已经抬赶，计算等待时长
                Long waitingTime = (System.currentTimeMillis() - startWaitTime)/1000;
                System.out.println("第"+(i+1)+"辆汽车等待"+waitingTime+"毫秒后进入车库");
                //通过sleep模拟停车时长
                int parkingTime = random.nextInt(10)+2;
                try {
                    TimeUnit.SECONDS.sleep(parkingTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //release方法用于释放资源，模拟驶出停车场
                parkingSystem.release();
                System.out.println("第"+(i+1)+"辆汽车停车"+parkingTime+"毫秒离开车库");
            }).start();
        });
    }
}
