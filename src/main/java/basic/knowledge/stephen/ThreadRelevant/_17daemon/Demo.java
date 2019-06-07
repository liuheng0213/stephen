package basic.knowledge.stephen.ThreadRelevant._17daemon;

//守护线程：可以看成是后台线程，依赖于前台线程，当前台线程全部结束时
//即使后台线程的任务代码没有执行完，也会立刻结束，比如垃圾回收线程，
//就属于守护线程

//线程被阻塞无法被中断。这时候救世主interrupt函数又回来了，
// 它可以迅速中断被阻塞的线程，抛出一个InterruptedException，把线程从阻塞状态中解救出来,
class Demo extends Thread {
    boolean flag = true;

    public synchronized void run() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag = false;
            }
            System.out.println(Thread.currentThread().getName() + "...Hello World!");
        }
    }
}

class test {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t2.setDaemon(true);//把t2线程设置成守护线程,t1线程和主线程都结束之后,t2也就必须结束了

        t1.start();
        t2.start();
        try {
            Thread.sleep(20);//主线程阻塞20毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 1;
        while (true) {
            if (i++ == 500) {
                System.out.println("i=" + i);
                t1.interrupt();//停止t1的阻塞,并抛出异常
                //让t2不能结束
                //t2.interrupt();
                break;

            }
        }
    }
}

