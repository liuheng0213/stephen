package basic.knowledge.stephen.algorithm_4_Edition.mock;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.entity.User;
import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class MockData {
    public static final Double[] DOUBLE_FOR_SORT_MOCK = new Double[]{0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2};
    public static final User[] FOR_SORT_MOCK = getUser();
    public static final Integer[] INTEGER_FOR_SORT_MOCK = getRandomIntegerArray();
    public static final MyQueue<Comparable> SORTED_QUEUE_FOR_MOCK_1 = getQueue1();
    public static final MyQueue<Comparable> SORTED_QUEUE_FOR_MOCK_2 = getQueue2();

    private static MyQueue<Comparable> getQueue2() {
        MyQueue<Comparable> objects = new MyQueue<>();
        objects.enqueue(1);
        objects.enqueue(2);
        objects.enqueue(3);
        objects.enqueue(4);
        objects.enqueue(5);
        objects.enqueue(6);
        objects.enqueue(7);
        return objects;
    }

    private static MyQueue<Comparable> getQueue1() {
        MyQueue<Comparable> objects = new MyQueue<>();
        objects.enqueue(2);
        objects.enqueue(3);
        objects.enqueue(4);
        objects.enqueue(5);
        objects.enqueue(7);
        objects.enqueue(9);
        objects.enqueue(10);
        objects.enqueue(11);
        objects.enqueue(12);
        objects.enqueue(16);
        return objects;
    }

    private static Integer[] getRandomIntegerArray() {
        Integer[] a = new Integer[88];
        for(int t = 0;t<88;t++){
            for(int i = 0;i<88;i++){
                a[i] = StdRandom.uniform(88);
            }
        }
        return a;
    }

    private static User[] getUser() {

        return new User[]{new User(21), new User(3),new User(2),new User(14)
        ,new User(5),new User(16),new User(71),new User(18),new User(9), new User(0),
                new User(13)};
    }
}
