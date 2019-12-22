package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

/**
 * 快速三项切分bently-McIlroy
 * Turkey's ninther
 */
public class _09E2_3_22And2_3_23 {
    private static final int INSERTION_SORT_CUTOFF = 8;

    private static final int MEDIAN_OF_3_CUTOFF = 40;


    public static void main(String[] args) {
        sort(MockData.INTEGER_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.INTEGER_FOR_SORT_MOCK);
    }

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        int n = hi - lo + 1;
        if (n <= INSERTION_SORT_CUTOFF) {
            insertSort(arr, lo, hi);
            return;
        }

        if (n <= MEDIAN_OF_3_CUTOFF) {
            int median = getMedian(arr, lo, (lo + hi) / 2, hi);
            SortUtil.exch(arr, median, lo);
        } else {
            // 对于较大的数组使用 Turkey Ninther 作为枢轴。
            int eps = n / 8;
            int mid = lo + n / 2;
            int m1 = getMedian(arr, lo, lo + eps, lo + eps + eps);
            int m2 = getMedian(arr, mid - eps, mid, mid + eps);
            int m3 = getMedian(arr, hi - eps - eps, hi - eps, hi);
            int ninther = getMedian(arr, m1, m2, m3);
            SortUtil.exch(arr, ninther, lo);
        }


        // size . 40
        int p = lo; //左侧= v
        int i = lo;
        int j = hi + 1;
        int q = hi + 1; //右侧 = v
        Comparable v = arr[lo];

        while (true) {
            while (SortUtil.less(arr[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            while (SortUtil.less(v, arr[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i == j && SortUtil.isEqual(v, arr[i])) {
                SortUtil.exch(arr, ++p, i);
            }

            if (i >= j) {
                break;
            }

            SortUtil.exch(arr, i, j);

            if (SortUtil.isEqual(v, arr[i])) {
                SortUtil.exch(arr, ++p, i);
            }

            if (SortUtil.isEqual(v, arr[j])) {
                SortUtil.exch(arr, --q, j);
            }
        }

        i = j + 1;//这个条件是保证下属操作后一定有i > j  i= j+1 只是在主循环的i == j 弹出时避免多余的复制, 其实这一部没啥必要
        for (int k = lo; k <= p; k++) {
            SortUtil.exch(arr, k, j--);
        }

        for (int k = hi; k >= q; k--) {
            SortUtil.exch(arr, k, i++);
        }

        sort(arr, lo, j);
        sort(arr, i, hi);
    }

    /**
     * 决策树!
     *
     * @param arr
     * @param lo
     * @param mid
     * @param hi
     * @return
     */
    private static int getMedian(Comparable[] arr, int lo, int mid, int hi) {
        return (SortUtil.less(arr[lo], arr[mid]) ?
                (SortUtil.less(arr[mid], arr[hi]) ? mid : SortUtil.less(arr[lo], arr[hi]) ? hi : lo)
                : (SortUtil.less(arr[hi], arr[mid]) ? mid : SortUtil.less(arr[hi], arr[lo]) ? hi : lo));
    }


    private static void insertSort(Comparable[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j >= lo + 1; j--) {
                if (SortUtil.less(arr[j], arr[j - 1])) {
                    SortUtil.exch(arr, j, j - 1);
                }
            }
        }
    }
}
