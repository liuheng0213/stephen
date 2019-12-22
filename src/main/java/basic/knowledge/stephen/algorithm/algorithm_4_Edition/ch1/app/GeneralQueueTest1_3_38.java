package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.app;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.queue.GeneralizedQueueByArray1_3_38;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.queue.GeneralizedQueueByLink1_3_38;
import org.junit.Test;

import java.util.Iterator;

public class GeneralQueueTest1_3_38 {
    @Test
    public void test1(){
        GeneralizedQueueByArray1_3_38<Integer> myqueue = new GeneralizedQueueByArray1_3_38<>();
        myqueue.enqueue(3);
        myqueue.enqueue(5);
        myqueue.enqueue(9);
        myqueue.enqueue(3);
        myqueue.enqueue(10);
        myqueue.enqueue(3);
        myqueue.enqueue(1);

        Integer delete = myqueue.delete(1);
        System.out.println(delete);

        System.out.println("=========================");

        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
        Iterator<Integer> iterator = myqueue.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println(i);
        }
    }

    @Test
    public void test2(){
        GeneralizedQueueByLink1_3_38<Integer> myqueue = new GeneralizedQueueByLink1_3_38<>();
        myqueue.enqueue(3);
        myqueue.enqueue(5);
        myqueue.enqueue(3);
        myqueue.enqueue(9);
        myqueue.enqueue(3);
        myqueue.enqueue(10);
        myqueue.enqueue(1);

//        Integer delete = myqueue.delete(1);
//        System.out.println(delete);


        System.out.println("=========================");
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
        /*Iterator<Integer> iterator = myqueue.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println(i);
        }*/
    }
}
