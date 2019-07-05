package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;
import edu.princeton.cs.algs4.StdRandom;

public class _09E2_2_15BottomUp {

    public static void main(String[] args) {
        MyQueue<MyQueue<Comparable>> result = createQueue(20);
        merge(result);
        System.out.println(result.peek().size());
        SortUtil.isSorted(result.peek());
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

        int originalSize = sorted1.size()+sorted2.size();
        for(int k = 1;k<=originalSize;k++){
            if(sorted1.size()==0){
                result.enqueue(sorted2.dequeue());
            }else if(sorted2.size()==0){
                result.enqueue(sorted1.dequeue());
            }else if(SortUtil.less(sorted1.peek(),sorted2.peek() )){
                result.enqueue(sorted1.dequeue());
            }else{
                result.enqueue(sorted2.dequeue());
            }
        }
        return result;
    }
}
