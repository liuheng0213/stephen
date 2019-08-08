package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

public class _01MergeSort {
    private static Comparable[] aux;

    public static void main(String[] args) {
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];  //比放在merge里面好很多, 不用new那么多个对象
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (SortUtil.less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

        //下面的代码,wrong,why? understand?????  正确, 第一个判断一定要加(i<=mid && j<=hi) &&

//        for (int k = lo; k <= hi; k++) {
//            if (SortUtil.less(aux[j], aux[i])) {
//                a[k] = aux[j++];
//            } else if (i > mid) {
//                a[k] = aux[j++];
//            } else if (j > hi) {
//                a[k] = aux[i++];
//            } else {
//                a[k] = aux[i++];
//            }
//        }
    }
}
