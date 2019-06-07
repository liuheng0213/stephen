package basic.knowledge.stephen.ThreadRelevant._11yieldAndJoin.yield;

class YieldThread implements Runnable{

    public void run() {
        for(int i=0;i<100;i++){

            if(i==20){
                //当i==20的时候，使用yield方法使当前线程让步
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+"===="+i);
        }
    };
}

public class JoinAndYieldTestDemo {
    public static void main(String[] args) {
        YieldThread yt=new YieldThread();
        Thread t1=new Thread(yt,"高级");
        t1.setPriority(Thread.MAX_PRIORITY);  //将t1线程设置成最高优先级

        Thread t2=new Thread(yt,"低级");
        t2.setPriority(Thread.MIN_PRIORITY);  //将t2线程设置成最低优先级

        t2.start();
        t1.start();
        System.out.println(Thread.activeCount());

    }
}
/**
 * yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
 * 因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
 * 但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 */
