package basic.knowledge.stephen.ThreadRelevant._13activeCount;

public class ThreadCount extends Thread{
    char c;
    public ThreadCount(String name, char c) {
        super(name);
        this.c = c;
    }
    public void run(){
        int k;
        char ch = c;
        System.out.println();
        System.out.print(getName()+": ");
        for(k = 0; k <= 2; ++k) {
            ch = (char)(c+k);
            System.out.print(ch + " ");
        }
        System.out.println(getName()+"end!");
    }

    public static void main(String[] args) {
        ThreadCount threadCount1 = new ThreadCount("th1", 'A');
        ThreadCount threadCount2 = new ThreadCount("th2", 'a');
        threadCount1.start();
        threadCount2.start();
        System.out.println("activeCount= " + Thread.activeCount());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.currentThread().getThreadGroup().list();
    }
}
