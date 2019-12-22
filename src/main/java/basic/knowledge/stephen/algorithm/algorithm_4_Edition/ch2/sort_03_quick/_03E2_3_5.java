package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_03_quick;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

/**
 * 2.3.5
 * 三向切分
 * 适合仅有两个元素的数组(大量重复元素)
 * 一轮就分清楚左中右了
 */
public class _03E2_3_5 {

    public static void main(String[] args) {
        sort(MockData.TWO_ELE_FOR_MOCK);
        SortUtil.isSorted(MockData.TWO_ELE_FOR_MOCK);
    }


    public static void sort(Comparable[] a) {
        for (int i = 1, lo = 0, hi = a.length - 1; i <= hi; ) {
            int comp = a[i].compareTo(a[lo]);
            if (comp < 0) {
                SortUtil.exch(a, lo++, i++);
            } else if (comp > 0) {
                SortUtil.exch(a, i, hi--);
            } else {
                i++;
            }
        }
    }
}
