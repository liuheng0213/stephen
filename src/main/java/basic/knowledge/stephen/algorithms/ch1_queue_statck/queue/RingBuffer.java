package basic.knowledge.stephen.algorithms.ch1_queue_statck.queue;

import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 环形缓冲区
 * 1.3.39
 * empty  消费者会等待消费
 * full   生产者等待存入
 */
public class RingBuffer<Item>{
    private Item[] items;
    private int maxLegnth = 5;//默认容量
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();


    //定义变量,作用类似指针
    //produceIndex往右走是+1  0代表没生产 items.length -1代表生成满了
    //consumeIndex往左走是+1  0代表没消费 items.length -1代表消费彻底

    private int producePos = 0;
    private int consumePos = 0;

    public RingBuffer(int N){
        this.items =  (Item[])new Object[N];
    }

    public RingBuffer() {
        this.items = (Item[])new Object[this.maxLegnth];
    }

    public boolean isEmpty(){
        return this.producePos == this.consumePos;
    }

    public boolean isFull(){
        int i =  this.producePos - this.consumePos ;
        return i == items.length;
    }

    public Item consume(){
        lock.lock();
        Item item = null;
        try {
            while(isEmpty()){
                condition.await();//阻塞当前线程
            }
            item = items[(consumePos++)% items.length];
            items[consumePos] = null;
            condition.signal();//通知其他线程可以了
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return item;
    }

    public void produce(Item item){
        lock.lock();
        try {
            while(isFull()){
                condition.await();
            }
            items[(producePos++)%items.length] = item;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

class Consumer implements Runnable{

    private RingBuffer<User> ringBuffer;

    public Consumer(RingBuffer<User> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            User user = ringBuffer.consume();
            System.out.println("consume:====>"+user.toString());
        }
    }
}

class Producer implements Runnable{

    private RingBuffer<User> ringBuffer;

    public Producer(RingBuffer<User> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            ringBuffer.produce(new User(i));
        }
    }
}

class APP{
    public static void main(String[] args) {
        RingBuffer<User> ringBuffer = new RingBuffer<>();

        new Thread(new Producer(ringBuffer)).start();
        new Thread(new Consumer(ringBuffer),"A").start();
    }
}