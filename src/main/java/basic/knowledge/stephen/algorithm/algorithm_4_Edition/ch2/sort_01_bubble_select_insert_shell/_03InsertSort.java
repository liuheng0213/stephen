package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

public class
_03InsertSort {
    public static void main(String[] args) {

        Integer[] as = new Integer[]{5,4,3,2,1};
        sort(as);
        System.out.println(SortUtil.isSorted(as));
    }

    /**
     * 每一轮保证了i 前是有序的
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1 && SortUtil.less(arr[j], arr[j - 1]); j--) {
                SortUtil.exch(arr, j, j - 1);
            }
        }
    }
}
