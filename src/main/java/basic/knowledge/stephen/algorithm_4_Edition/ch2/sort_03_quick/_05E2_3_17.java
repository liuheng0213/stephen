package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

/**
 * 算法_01 去掉边界检查
 */
public class _05E2_3_17 {
    public static void main(String[] args) {
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
    }

    public static void sort(Double[] a) {
        //lo后面的最大值
        int maxIndex = 0;
        for (int i = 1; i < a.length; i++)
        {
            if (SortUtil.less(a[maxIndex], a[i]))
                maxIndex = i;
        }
        SortUtil.exch(a,a.length-1 , maxIndex);
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

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (SortUtil.less(a[++i], v)) {
//                if (i == hi) {
//                    break;
//                }
            }


            while (SortUtil.less(v, a[--j])) {
//                if (j == lo) {    //去掉边界检查无论如何  a[lo] 不可能大于v  永远进不了while
//                    break;
//                }
            }

            if (i >= j) {
                break;
            }

            SortUtil.exch(a, i, j);
        }

        SortUtil.exch(a, lo, j);
        return j;
    }
}
