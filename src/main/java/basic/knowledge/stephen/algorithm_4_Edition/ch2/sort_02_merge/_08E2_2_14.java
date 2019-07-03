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
        int originalSize1 = sorted1.size();
        int originalSize2 = sorted2.size();

        Comparable[] aux = new Comparable[originalSize1 + originalSize2];

        for(int i = 0;i< aux.length;i++){
            if(sorted1.size()>0){
                aux[i] = sorted1.dequeue();
            }else{
                aux[i] = sorted2.dequeue();
            }
        }

        int i = 0;
        int j = originalSize1;

        for(int k = 0;k<originalSize1+originalSize2;k++){
            if(i>originalSize1-1){
                result.enqueue(aux[j++]);
            }else if(j>originalSize1+originalSize2-1){
                result.enqueue(aux[i++]);
            }else if(SortUtil.less(aux[i],aux[j])){
                result.enqueue(aux[i++]);
            }else {
                result.enqueue(aux[j++]);
            }
        }
        return result;
    }
}
