package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

public class _04ShellSort {
    public static void main(String[] args) {
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >=h && SortUtil.less(arr[j], arr[j - h]); j -= h) {
                    SortUtil.exch(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
