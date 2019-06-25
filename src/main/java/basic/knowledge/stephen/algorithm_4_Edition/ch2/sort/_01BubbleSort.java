package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

import java.util.Arrays;

public class _01BubbleSort {
    public static void main(String[] args) {
        sort(MockData.FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.FOR_SORT_MOCK);
    }

    private static void sort(Comparable[] arr) {
        for(int i = 1;i<arr.length;i++){
            for(int j = 0;j<arr.length - (i-1)-1;j++){
                if(SortUtil.less(arr[j+1],arr[j])){
                    SortUtil.exch(arr, j,j+1);
                }
            }
        }

    }
}
