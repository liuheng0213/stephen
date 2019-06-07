package basic.knowledge.stephen.ThreadRelevant._06ThreadPool.scheduledThreadPool;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        //需求:在任务执行时间小于间隔时间的情况下，程序以起始时间为准则，每隔指定时间执行一次，不受任务执行时间影响。
        //本次: 任务执行时间为:end -start(or sleepTime)  间隔时间:period
        scheduleAtFixedRate(service,1000);

        //需求:当执行任务时间大于间隔时间，此方法不会重新开启一个新的任务进行执行，
        //而是等待原有任务执行完成，马上开启下一个任务进行执行。此时，执行间隔时间已经被打乱。
        //scheduleAtFixedRate(service,6000);

        //需求:当执行任务小于延迟时间时，第一个任务执行之后，延迟指定时间，然后开始执行第二个任务。
        //scheduleWithFixedDelay(service,1000);

        //需求:当执行任务大于延迟时间时，第一个任务执行之后，延迟指定时间，然后开始执行第二个任务。


    }

    /**
     *
     * @param service
     * @param sleepTime sleepTime  模拟的执行花费时间
     */
    private static void scheduleAtFixedRate(ScheduledExecutorService service, final int sleepTime){
        /**
         * initailDelay, 运行时第一个输出的延迟
         * period: 两个输出线程之间的延迟
         */
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.out.println("scheduleAtFixedRate 开始执行时间:" +
                        DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(sleepTime);//sleepTime  模拟当前线程的执行时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.out.println("scheduleAtFixedRate 执行花费时间=" + (end -start)/1000 + "m");
                System.out.println("scheduleAtFixedRate 执行完成时间："
                        + DateFormat.getTimeInstance().format(new Date()));
                System.out.println(Thread.currentThread().getName());
                System.out.println("======================================");
            }
        },3000,2000,TimeUnit.MILLISECONDS);
    }

    private static void scheduleWithFixedDelay(ScheduledExecutorService service,final int sleepTime){
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.out.println("scheduleWithFixedDelay 开始执行时间:" +
                        DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.out.println("scheduleWithFixedDelay执行花费时间=" + (end -start)/1000 + "m");
                System.out.println("scheduleWithFixedDelay执行完成时间："
                        + DateFormat.getTimeInstance().format(new Date()));
                System.out.println("======================================");
            }
        },1000,5000,TimeUnit.MILLISECONDS);
    }
}