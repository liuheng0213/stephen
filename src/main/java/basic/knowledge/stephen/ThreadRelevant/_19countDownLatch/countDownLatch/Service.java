package basic.knowledge.stephen.ThreadRelevant._19countDownLatch.countDownLatch;

public class Service {

    public void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin timer " + System.currentTimeMillis());
            Thread.sleep((long) (Math.random()*10000));//模拟每个跑步选手跑完100米所需的时间
            System.out.println(Thread.currentThread().getName() + " end timer " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

