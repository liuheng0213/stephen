package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

/**
 * 优化:三取样切分
 * 三取样切分的三点对应算法的lo, lo,hi ,切分点即partition point 是中位数,限定好上下限可避免边界判断
 * 三分取样切分的首尾下表并不一定非得是original的lo, lo, hi. 只要符合lo<mid<hi即可.
 *  所以这里直接把前三项排序了, 设置成首中 尾
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
        if (hi - lo <= 1) {  //这里一定要注意三取样如果子数组是小于3的长度时  会出问题.
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

        SortUtil.exch(arr,mid ,lo);//中位数放最左侧
        Comparable v = arr[lo];

        int i = lo;
        int j = hi +1;

        while(true){
            while(SortUtil.less(arr[++i],v));
            while(SortUtil.less(v,arr[--j]));

            if(i >= j){
                break;
            }

            SortUtil.exch(arr,i,j);
        }

        SortUtil.exch(arr,lo,j);
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
