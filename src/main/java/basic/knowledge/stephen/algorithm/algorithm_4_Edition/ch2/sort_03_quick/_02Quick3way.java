package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

/**
 * 三项切分的快速排序
 */
public class _02Quick3way {
    public static void main(String[] args) {
        Double[] arr = new Double[]{4.0,1.0,2.0,2.0,3.0};
        sort(arr);
        SortUtil.isSorted(arr);
    }

    public static void sort(Double[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Double[] a, int lo, int hi) {
        if(lo >= hi){
            return;
        }
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        Comparable v = a[lo];

        //以下是典型贪心算法
        while (i <= gt) {
            int compare = v.compareTo(a[i]);
            if (compare < 0) {//i value  比 partition point 更大
                SortUtil.exch(a, gt--, i);
            } else if (compare > 0) {
                SortUtil.exch(a, lt++, i++);
            } else {
                i++;
            }
        }

        sort(a,lo,lt - 1);
        sort(a,gt+1,hi);
    }
}
