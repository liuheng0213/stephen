package basic.knowledge.stephen.ThreadRelevant._11yieldAndJoin.join;

/**
 * join的用法， 在某些情况下，如果子线程里要进行大量的耗时的运算，
 * 主线程可能会在子线程执行完之前结束，但是如果主线程又需要用到子线程的处理结果，
 * 也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()。
 * 让子线程调用join()方法
 */
public class JoinAndYieldTestDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");//main start
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2(t1);  //t1时t2的子线程
        try {
            t1.start();
            Thread.sleep(1000);
            t2.start();
            t2.join();      //写这个t2.join()因为t2是main线程的子线程,需要t2执行完后执行main线程
        } catch (Exception e) {
            System.out.println("exception from main");
        }

        System.out.println(threadName + " end.");//main end

    }

}
/**
 * t2一定在t1之后才结束，main线程则一定在t2结束之后结束，这都要归功于各自调用的join方法。
 */
