package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 优化:五取样切分
 */
public class _07E2_3_19 {
    public static void main(String[] args) {
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (hi - lo <= 2) {  //这里一定要注意三取样如果子数组是小于3的长度时  会出问题.
            insertSort(arr, lo, hi);
            return;
        }

        int j = partition(arr, lo, hi);

        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
       //0,1,2,3,4
        if(SortUtil.less(arr[lo+4],arr[lo+3])){
            SortUtil.exch(arr,lo+4 , lo+3);
        }

        if(SortUtil.less(arr[lo+2],arr[lo+1])){
            SortUtil.exch(arr,lo+2 , lo+1);
        }

        if(SortUtil.less(arr[lo+3],arr[lo+1])){
            SortUtil.exch(arr,lo+3 , lo+1);
            SortUtil.exch(arr,lo+4 , lo+2);
        }

        //now 1 在1,2,3,4中最小
        //现在还0,1  重新比较1,2并排序
        SortUtil.exch(arr,lo+1 , lo);

        if(SortUtil.less(arr[lo+2],arr[lo+1])){
            SortUtil.exch(arr,lo+2 , lo+1);
        }

        if(SortUtil.less(arr[lo+3],arr[lo+1])){
            SortUtil.exch(arr,lo+3 , lo+1);
            SortUtil.exch(arr,lo+4 , lo+2);
        }

        if(SortUtil.less(arr[lo+3],arr[lo+2])){
            SortUtil.exch(arr,lo+3 , lo+2);
        }

        //中位数就是2
       /* 取样完毕后，a b 是最小值和次小值（这里没有对应关系，a 也可以是次小值）。
        d 和 e 是最大值和次大值（同样没有对应关系）。
        我们把 d 和 e 放到数组的最后作为哨兵，去掉右边界的判断。*/
       SortUtil.exch(arr,lo+1 ,hi-1);
       SortUtil.exch(arr,lo+2 ,hi);

        Comparable v = arr[hi - 1];

        int i = lo;
        int j = hi - 1;

        while (true) {
            while (SortUtil.less(arr[++i], v)) ;
            while (SortUtil.less(v, arr[--j])) ;

            if (i >= j) {
                break;
            }

            SortUtil.exch(arr, i, j);
        }

        SortUtil.exch(arr, hi - 1, i);
        return i;
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
