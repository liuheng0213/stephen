package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

public class _03InsertSort {
    public static void main(String[] args) {
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
    }

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1 && SortUtil.less(arr[j], arr[j - 1]); j--) {
                SortUtil.exch(arr, j, j - 1);
            }
        }
    }
}
