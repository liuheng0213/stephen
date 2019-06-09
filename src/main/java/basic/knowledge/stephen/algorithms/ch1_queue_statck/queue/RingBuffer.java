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
    private int maxLegnth = 16;//默认容量
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();


    //定义变量,作用类似指针
    //produceIndex往右走是+1  0代表没生产 items.length -1代表生成满了
    //consumeIndex往左走是+1  0代表没消费 items.length -1代表消费彻底

    private int produceIndex = 0;
    private int consumeIndex = 0;

    public RingBuffer(int N){
        this.items =  (Item[])new Object[N];
    }

    public RingBuffer() {
        this.items = (Item[])new Object[this.maxLegnth];
    }

    public boolean isEmpty(){
        return this.produceIndex ==0 &&  this.consumeIndex==0;
    }

    public boolean isFull(){
        return consumeIndex ==0 && produceIndex == items.length;
    }

    public Item consume(){
        while(isEmpty()){}
        Item item = items[(consumeIndex++)% (items.length -1)];
        items[consumeIndex] = null;
        return item;
    }

    public void produce(Item item){
        while(isFull()){}
        items[(produceIndex++)%(items.length -1)] = item;
    }

}