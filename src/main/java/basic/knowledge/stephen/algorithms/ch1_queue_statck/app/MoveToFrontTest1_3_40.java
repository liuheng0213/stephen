package basic.knowledge.stephen.algorithms.ch1_queue_statck.app;

import basic.knowledge.stephen.algorithms.ch1_queue_statck.queue.MoveToFront1_3_40;
import org.junit.Test;

import java.util.Iterator;

public class MoveToFrontTest1_3_40 {
    @Test
    public void test1(){
        MoveToFront1_3_40 moveToFront = new MoveToFront1_3_40();
        moveToFront.enqueue(1);
        moveToFront.enqueue(2);
        moveToFront.enqueue(3);
        moveToFront.enqueue(4);
        moveToFront.enqueue(3);
        moveToFront.enqueue(3);
        moveToFront.enqueue(1);

        Iterator iterator = moveToFront.iterator();
        while(iterator.hasNext()){
            Integer next = (Integer) iterator.next();
            System.out.println(next);
        }

    }
}
