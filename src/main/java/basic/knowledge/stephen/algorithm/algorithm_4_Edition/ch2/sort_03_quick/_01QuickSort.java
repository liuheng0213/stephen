package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 最优状况:
 * 递归树均分
 * 最差状况, 斜递归树
 */
public class _01QuickSort {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{8, 2, 9, 6, 12, 13};
        Integer[] arr1 = new Integer[]{4, 8, 7, 6, 5};
        sort(MockData.INTEGER_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.INTEGER_FOR_SORT_MOCK);
    }

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 时间复杂度的计算 sort(n) 为T(n)  最优下
     * T(n)  = n+ 2T(n/2)
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo;
        int j = hi + 1;

        while (true) {
            //一旦a[i] >= v or i == hi 就出循环 注意 Less 一定不能包括equals
            while (SortUtil.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            //一旦a[j] <= v ,就出循环
            while (SortUtil.less(v, a[--j])) {
//                if (j == lo) {    //去掉边界检查无论如何  a[lo] 不可能大于v  永远进不了
//                    break;
//                }
            }


            //两种可能 1: i == j 如果arr[i] = arr[j] = arr[lo]  如 Integer[] arr = new Integer[]{8, 2, 3, 7, 8, 12, 13};;
            // 2 i = j+1
            if (i >= j) {
                break;
            }

            SortUtil.exch(a, i, j);
        }

        SortUtil.exch(a, lo, j);//必须和j  而不能和i 换 要保证换后 左边的的小于v
        return j;
    }
}
