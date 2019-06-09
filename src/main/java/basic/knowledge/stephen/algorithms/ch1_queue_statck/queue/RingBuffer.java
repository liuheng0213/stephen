package basic.knowledge.stephen.algorithms.ch1_queue_statck.queue;

import java.util.Iterator;

/**
 * 环形缓冲区
 * 1.3.39
 * empty  消费者会等待消费
 * full   生产者等待存入
 */
public class RingBuffer<Item>{
    private Item[] items;
    private int maxLegnth = 16;//默认容量

    //定义变量,作用类似指针
    //first往右走是+1
    //last往左走是+1
    private int first = 0;
    private int last = 0;

    public RingBuffer(int N){
        this.items =  (Item[])new Object[N];
    }

    public RingBuffer() {
        this.items = (Item[])new Object[this.maxLegnth];
    }

    public boolean isEmpty(){
        return this.first == this.last;
    }

    public boolean isFull(){

    }

}