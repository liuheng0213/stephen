package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.app;


import basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.queue.JosephusQueue1_3_37;
import org.junit.Test;

import java.util.Iterator;

public class JosephusQueueTest1_3_37 {
    @Test
    public void test1_3_37(){
        JosephusQueue1_3_37 myqueue = new JosephusQueue1_3_37();
        myqueue.enqueue(1);
        myqueue.enqueue(2);
        myqueue.enqueue(3);
        myqueue.enqueue(4);
        myqueue.enqueue(6);
        myqueue.enqueue(7);
        myqueue.enqueue(9);
        myqueue.enqueue(10);
        myqueue.enqueue(11);
        myqueue.enqueue(13);
        myqueue.enqueue(16);
        myqueue.enqueue(18);
        myqueue.enqueue(19);

//        myqueue.dequeue();
//        Iterator iterator = myqueue.iterator();
//        while(iterator.hasNext()){
//            Integer next = (Integer) iterator.next();
//            System.out.println(next);
//        }

        JosephusQueue1_3_37 newQueue = myqueue.storeM(4,myqueue);

        Iterator iterator2 = newQueue.iterator();
        while(iterator2.hasNext()){
            Integer next = (Integer) iterator2.next();
            System.out.println(next);
        }


    }
}
