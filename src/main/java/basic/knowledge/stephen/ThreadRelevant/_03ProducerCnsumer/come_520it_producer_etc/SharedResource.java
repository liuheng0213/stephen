package basic.knowledge.stephen.ThreadRelevant._03ProducerCnsumer.come_520it_producer_etc;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {

    private String name;
    private AtomicInteger countAtomi = new AtomicInteger(0);
    private int count = 0;//wrong  即便在synchronized也要用atomic去自增 synchronized是 一行行语句之间是原子的 但是count++ 内部还是非原子的
    private Gender gender;
    private boolean isEmpty = true;

    synchronized public void countToTen() {
        try {
           /* while (countAtomi.get() == 10) {
                this.wait();    //let current thread wait until....,
            }*/
            while (count == 10) {
                this.wait();    //let current thread wait until....,
            }
            Thread.sleep(10);
            //countAtomi.incrementAndGet();
            count++;
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void printCount() {
        try {
            /*while (countAtomi.get() != 10) {
                this.wait();    //let current thread wait until....,
            }*/
            while (count != 10) {
                this.wait();    //let current thread wait until....,
            }
            Thread.sleep(10);
            //System.out.println("count is " + countAtomi.get());
            System.out.println("count is " + count);
            //countAtomi.compareAndSet(10,0);
            count= 0;
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void push(String name, Gender gender) throws InterruptedException {
        try {
            while (!isEmpty) {
                this.wait();    //let current thread wait until....,
            }
            this.name = name;
            Thread.sleep(100);
            this.gender = gender;
            isEmpty = false;
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    synchronized public void popup() {
        try {
            while (isEmpty) {
                this.wait();
            }
            Thread.sleep(10);
            System.out.println("popup: " + name + "=" + gender);
            isEmpty = true;
            this.notify();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


enum Gender {
    MALE, FEMALE;
}



