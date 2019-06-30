package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell;

import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

public class _03InsertSort {
    public static void main(String[] args) {
//        sort(MockData.DOUBLE_FOR_SORT_MOCK);
//        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);

        Integer[] as = new Integer[]{5,4,3,2,1};
        sort(as);
    }

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1 && SortUtil.less(arr[j], arr[j - 1]); j--) {
                SortUtil.exch(arr, j, j - 1);
            }
        }
    }
}
