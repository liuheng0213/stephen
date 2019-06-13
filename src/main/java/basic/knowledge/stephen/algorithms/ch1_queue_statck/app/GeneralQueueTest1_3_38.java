package basic.knowledge.stephen.algorithms.ch1_queue_statck.app;

import basic.knowledge.stephen.algorithms.ch1_queue_statck.queue.GeneralizedQueueByArray;
import basic.knowledge.stephen.algorithms.ch1_queue_statck.queue.GeneralizedQueueByLink;
import org.junit.Test;

import java.util.Iterator;

public class GeneralQueueTest1_3_38 {
    @Test
    public void test1(){
        GeneralizedQueueByArray<Integer> myqueue = new GeneralizedQueueByArray<>();
        myqueue.enqueue(3);
        myqueue.enqueue(1);
        myqueue.enqueue(5);
        myqueue.enqueue(3);
        myqueue.enqueue(9);
        myqueue.enqueue(3);
        myqueue.enqueue(10);

        Integer delete = myqueue.delete(3);
        System.out.println(delete);

        System.out.println("=========================");

        Iterator<Integer> iterator = myqueue.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println(i);
        }
    }

    @Test
    public void test2(){
        GeneralizedQueueByLink<Integer> myqueue = new GeneralizedQueueByLink<>();
        myqueue.enqueue(3);
        myqueue.enqueue(1);
        myqueue.enqueue(5);
        myqueue.enqueue(3);
        myqueue.enqueue(9);
        myqueue.enqueue(3);
        myqueue.enqueue(10);

        Integer delete = myqueue.delete(3);
        System.out.println(delete);

        System.out.println("=========================");

        Iterator<Integer> iterator = myqueue.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println(i);
        }
    }
}
