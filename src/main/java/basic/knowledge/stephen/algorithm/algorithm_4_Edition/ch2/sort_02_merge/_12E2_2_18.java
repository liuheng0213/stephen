package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.queue.MyQueue;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 打乱链表
 */
public class _12E2_2_18 {
    public static void main(String[] args) {
        System.out.println(MockData.SORTED_QUEUE_FOR_MOCK_1.size());
        MyQueue<Comparable> shuffle = shuffle(MockData.SORTED_QUEUE_FOR_MOCK_1);

        System.out.println(shuffle.size());
    }

    private static MyQueue<Comparable> shuffle(MyQueue<Comparable> queue) {
        MyQueue<MyQueue<Comparable>> queues = new MyQueue<>();
        queues.enqueue(queue);

        //split 2 one
        MyQueue<Comparable> aux = null;
        Comparable dequeue = null;//弹出的元素

        int originalSize = queue.size();//注意链表的size在变动

        for (int i = 1; i <= originalSize; i++) {
            dequeue = queue.dequeue();
            aux = new MyQueue<>();
            aux.enqueue(dequeue);
            queues.enqueue(aux);
        }
        queues.dequeue();
        //merge
        randomMerge(queues);

        queue = queues.dequeue();
        return queue;


    }

    private static void randomMerge(MyQueue<MyQueue<Comparable>> queues) {
        while (queues.size() > 1) {
            MyQueue<Comparable> dequeue1 = queues.dequeue();
            MyQueue<Comparable> dequeue2 = queues.dequeue();
            MyQueue<Comparable> merge = randomMerge(dequeue1, dequeue2);
            queues.enqueue(merge);
        }
    }

    public static MyQueue<Comparable> randomMerge(MyQueue<Comparable> queue1, MyQueue<Comparable> queue2) {
        MyQueue<Comparable> result = new MyQueue<>();

        int originalSize1 = queue1.size();

        int originalSize2 = queue2.size();

        for (int k = 1; k <= originalSize2 + originalSize1; k++) {
            if (queue1.size() == 0) {
                result.enqueue(queue2.dequeue());
            } else if (queue2.size() == 0) {
                result.enqueue(queue1.dequeue());
            }else{
                int random = StdRandom.uniform(2);//选择queue1  还是queue2
                if(random == 0){  //1
                    result.enqueue(queue1.findAndDeleteByIndex(StdRandom.uniform(queue1.size())));
                }else{//2
                    result.enqueue(queue2.findAndDeleteByIndex(StdRandom.uniform(queue2.size())));
                }
            }

        }
        return result;
    }


}
