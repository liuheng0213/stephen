package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

/**
 * 最优状况:
 *  递归树均分
 *  最差状况, 斜递归树
 */
public class _01QuickSort {
    public static void main(String[] args) {
        sort(MockData.SHORT_INTEGER);
        SortUtil.isSorted(MockData.SHORT_INTEGER);
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
            while (SortUtil.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }


            while (SortUtil.less(v, a[--j])) {
//                if (j == lo) {    //去掉边界检查无论如何  a[lo] 不可能大于v  永远进不了while
//                    break;
//                }
            }

            if (i >= j) {  //两种可能 1: i == j 如果arr[i] = arr[j] = arr[lo];2 i = j+1
                break;
            }

            SortUtil.exch(a, i, j);
        }

        SortUtil.exch(a, lo, j);
        return j;
    }
}
