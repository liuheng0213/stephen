package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

/**
 * 优化:三取样切分
 */
public class _06E2_3_18 {
    public static void main(String[] args) {
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (hi - lo <= 15) {
            insertSort(arr, lo, hi);
            return;
        }

        int j = partition(arr, lo, hi);

        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        int mid = (lo + hi) / 2;
        //找到最大的
        if (SortUtil.less(arr[mid], arr[lo])) {
            SortUtil.exch(arr,lo ,mid );
        }
        if (SortUtil.less(arr[hi], arr[mid])) {
            SortUtil.exch(arr,hi ,mid);
        }
        //找到第二大的
        if (SortUtil.less(arr[mid], arr[lo])) {
            SortUtil.exch(arr,lo ,mid);
        }
        Comparable v = arr[mid];

        SortUtil.exch(arr,mid ,hi-1);

        int i = lo;
        int j = hi -1;

        while(true){
            while(SortUtil.less(arr[++i],v));
            while(SortUtil.less(v,arr[--j]));

            if(i >= j){
                break;
            }

            SortUtil.exch(arr,i ,j );
        }

        SortUtil.exch(arr,lo ,j );
        return j;
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
