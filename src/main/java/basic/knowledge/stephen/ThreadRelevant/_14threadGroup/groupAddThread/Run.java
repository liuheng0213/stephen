package basic.knowledge.stephen.ThreadRelevant._14threadGroup.groupAddThread;

public class Run {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadGroup group = new ThreadGroup("刘衡的线程组");
        Thread t1 = new Thread(group,a);
        Thread t2 = new Thread(group,b);
        t1.start();
        t2.start();
        System.out.println("活动线程数为:" + Thread.activeCount());
        System.out.println("线程组的名称为:" + group.getName());
        Thread.currentThread().getThreadGroup().list();
    }
}

class ThreadA extends Thread{

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadB extends Thread{

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
