package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;
import edu.princeton.cs.algs4.StdRandom;

public class _09E2_2_15BottomUp {

    public static void main(String[] args) {
        MyQueue<MyQueue<Comparable>> result = createQueue(20);
        merge(result);
        System.out.println(result.peek().peek());
    }

    private static void merge(MyQueue<MyQueue<Comparable>> queue) {

        while (queue.size() > 1) {
            MyQueue<Comparable> dequeue1 = queue.dequeue();
            MyQueue<Comparable> dequeue2 = queue.dequeue();
            MyQueue<Comparable> merge = merge(dequeue1, dequeue2);
            queue.enqueue(merge);
        }

    }

    private static MyQueue<MyQueue<Comparable>> createQueue(int n) {
        MyQueue<MyQueue<Comparable>> queues = new MyQueue<>();
        for (int i = 1; i <= n; i++) {
            MyQueue<Comparable> queue = new MyQueue<>();
            queue.enqueue(StdRandom.uniform(n));
            queues.enqueue(queue);
        }
        return queues;
    }

    public static MyQueue<Comparable> merge(MyQueue<Comparable> sorted1, MyQueue<Comparable> sorted2) {
        MyQueue<Comparable> result = new MyQueue<>();
        int originalSize1 = sorted1.size();
        int originalSize2 = sorted2.size();

        Comparable[] aux = new Comparable[originalSize1 + originalSize2];

        for (int i = 0; i < aux.length; i++) {
            if (sorted1.size() > 0) {
                aux[i] = sorted1.dequeue();
            } else {
                aux[i] = sorted2.dequeue();
            }
        }

        int i = 0;
        int j = originalSize1;

        for (int k = 0; k < originalSize1 + originalSize2; k++) {
            if (i > originalSize1 - 1) {
                result.enqueue(aux[j++]);
            } else if (j > originalSize1 + originalSize2 - 1) {
                result.enqueue(aux[i++]);
            } else if (SortUtil.less(aux[i], aux[j])) {
                result.enqueue(aux[i++]);
            } else {
                result.enqueue(aux[j++]);
            }
        }
        return result;
    }
}
