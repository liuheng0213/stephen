package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;


public class _08E2_2_14 {

    public static void main(String[] args) {

        MyQueue<Comparable> result = merge(MockData.SORTED_QUEUE_FOR_MOCK_1, MockData.SORTED_QUEUE_FOR_MOCK_2);
        SortUtil.isSorted(result);
    }

    public static MyQueue<Comparable> merge(MyQueue<Comparable> sorted1, MyQueue<Comparable> sorted2) {
        MyQueue<Comparable> result = new MyQueue<>();

        for(int k = 1;k<=sorted1.size()+sorted2.size();k++){
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
