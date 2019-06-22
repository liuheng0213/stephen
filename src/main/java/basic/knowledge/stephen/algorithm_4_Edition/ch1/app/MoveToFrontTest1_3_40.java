package basic.knowledge.stephen.algorithm_4_Edition.ch1.app;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MoveToFront1_3_40;
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
