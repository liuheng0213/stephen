package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

/**
 * 自然的归并排序
 * 对链表进行排序
 * 模仿   _09E2_2_15BottomUp
 */
public class _11E2_2_17 {
    public static void main(String[] args) {
        MyQueue<Comparable> sorted = sort(MockData.NOT_SORTED_QUEUE_FOR_MOCK);
        SortUtil.isSorted(sorted);
    }


    public static MyQueue<Comparable> sort(MyQueue<Comparable> queue) {
        MyQueue<MyQueue<Comparable>> queues = new MyQueue<>();
        queues.enqueue(queue);

        //split
        Comparable pre = null;//标记链表前一个元素
        MyQueue<Comparable> aux = null;
        Comparable dequeue = null;
        int originalSize = queue.size();//注意链表的size在变动

        for (int i = 1; i <= originalSize; i++) {

            if (pre == null) {
                dequeue = queue.dequeue();
                aux = new MyQueue<>();
                aux.enqueue(dequeue);
            }else if (SortUtil.less(queue.peek(), pre)){
                queues.enqueue(aux);
                dequeue = queue.dequeue();
                aux = new MyQueue<>();
                aux.enqueue(dequeue);
            }else{
                dequeue = queue.dequeue();
                aux.enqueue(dequeue);

            }

            if(i == originalSize){
                queues.enqueue(aux);
            }

            pre = dequeue;
        }

        //merge
        merge(queues);

        queue = queues.dequeue();
        return queue;
    }

    //_09E2_2_15BottomUp的方法
    private static void merge(MyQueue<MyQueue<Comparable>> queues) {

        while (queues.size() > 1) {
            MyQueue<Comparable> dequeue1 = queues.dequeue();
            MyQueue<Comparable> dequeue2 = queues.dequeue();
            MyQueue<Comparable> merge = merge(dequeue1, dequeue2);
            queues.enqueue(merge);
        }

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
