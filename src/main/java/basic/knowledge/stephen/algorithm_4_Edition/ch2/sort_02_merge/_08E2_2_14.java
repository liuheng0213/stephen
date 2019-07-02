package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;


public class _08E2_2_14 {

    public static void main(String[] args) {
        Integer[] sorted1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] sorted2 = {1, 4, 5, 8, 9, 10, 11, 12, 14,18};
        Comparable[] result = sort(sorted1, sorted2);
        SortUtil.isSorted(result);
    }

    public static Comparable[] sort(Comparable[] sorted1, Comparable[] sorted2) {
        int index1 = 0;
        int index2 = 0;

        Comparable[] resultArr = new Integer[sorted1.length + sorted2.length];
        for (int i = 0; i < resultArr.length; i++) {
            if(index1 > sorted1.length-1){
                resultArr[i] = sorted2[index2++];
            }else if(index2 >sorted2.length-1){
                resultArr[i] = sorted1[index1++];
            }else if(SortUtil.less(sorted1[index1],sorted2[index2])){
                resultArr[i] = sorted1[index1++];
            }else{
                resultArr[i] = sorted2[index2++];
            }
        }
        return resultArr;
    }
}
