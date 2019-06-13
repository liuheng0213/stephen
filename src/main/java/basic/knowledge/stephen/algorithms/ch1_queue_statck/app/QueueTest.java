package basic.knowledge.stephen.algorithms.ch1_queue_statck.app;




import basic.knowledge.stephen.algorithms.ch1_queue_statck.queue.MyQueue;
import basic.knowledge.stephen.algorithms.ch1_queue_statck.entity.User;
import org.junit.Test;

import java.util.Iterator;

public class QueueTest {
    @Test
    public void testQueue(){
        MyQueue<User> myqueue = new MyQueue<>();
        myqueue.enqueue(new User("1"));
        myqueue.enqueue(new User("2"));
        myqueue.enqueue(new User("3"));

        Iterator<User> iterator = myqueue.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            System.out.println(user);
        }
        User first = myqueue.dequeue();
        System.out.println(first);
        System.out.println("-------------");
        Iterator<User> iterator2 = myqueue.iterator();
        while(iterator2.hasNext()){
            User user = iterator2.next();
            System.out.println(user);
        }

        System.out.println(myqueue.size());
    }
}
