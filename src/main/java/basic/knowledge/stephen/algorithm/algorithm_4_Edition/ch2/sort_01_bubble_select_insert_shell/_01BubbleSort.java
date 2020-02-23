package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

public class _01BubbleSort {
    public static void main(String[] args) {
        sort(MockData.INTEGER_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.INTEGER_FOR_SORT_MOCK);
    }

    //每一轮把最大的放后面
    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - (i - 1) - 1; j++) {
                if (SortUtil.less(arr[j + 1], arr[j])) {
                    SortUtil.exch(arr, j, j + 1);
                }
            }
        }

    }
}
