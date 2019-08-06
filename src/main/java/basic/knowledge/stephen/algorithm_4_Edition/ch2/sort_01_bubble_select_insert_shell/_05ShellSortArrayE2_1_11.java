package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

/**
 * 希尔排序将递增数列放进数组里
 */
public class _05ShellSortArrayE2_1_11 {
    public static void main(String[] args) {
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        int m = (int) (Math.log(2 * n + 1) / Math.log(3));
        int[] caches = new int[m];

        int k = 0;
        int h = 1;
        while (h < n / 3) {
            caches[k++] = h;
            h = h * 3 + 1;
            if (h >= n / 3) {
                caches[k] = h;
            }
        }
        while (k >= 0 && caches[k] >= 1) {
            for (int i = caches[k]; i < n; i++) {
                for (int j = i; j >=caches[k] && SortUtil.less(arr[j], arr[j - caches[k]]); j -= caches[k]) {
                    SortUtil.exch(arr, j, j - caches[k]);
                }
            }
            k--;
        }
    }
}
