package basic.knowledge.stephen.ThreadRelevant._04ThreadLocalDemo;

public class ThreadLocalTest1 {
    //创建一个Integer型的线程本地变量
    public static final ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    //计数
    static class Counter implements Runnable{
        @Override
        public void run() {
            //获取当前线程的本地变量，然后累加100次
            int num = local.get();
            for (int i = 0; i < 10000; i++) {
                num++;
            }
            //重新设置累加后的本地变量
            local.set(num);
            System.out.println(Thread.currentThread().getName() + " : "+ local.get());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Counter() ,"CounterThread-[" + i+"]");
            threads[i].start();
        }
    }
}