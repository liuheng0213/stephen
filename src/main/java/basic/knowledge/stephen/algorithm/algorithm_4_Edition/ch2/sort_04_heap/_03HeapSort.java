package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

public class _03HeapSort {
    public static void main(String[] args) {
        sort(MockData.INTEGER_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.INTEGER_FOR_SORT_MOCK);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        //堆有序  此k是堆的索引 而不是数组的索引
        for (int k = n / 2; k >= 1; k--) {
            sink(arr, k, n);
        }

        //排序--利用堆有序的特点, 即根节点最大
        while (n > 1) {
            SortUtil.exch(arr, 0, n - 1);
            n--;
            sink(arr, 1, n);
        }

    }

    private static void sink(Comparable[] arr, int k, int n) {
        while (k * 2 < n) {
            int j = 2 * k;
            if (j < n && SortUtil.less(arr[j - 1], arr[j])) {
                j++;
            }

            if (SortUtil.less(arr[k - 1], arr[j - 1])) {
                SortUtil.exch(arr, k - 1, j - 1);
            } else {
                break;
            }

            k = j;
        }
    }
}
