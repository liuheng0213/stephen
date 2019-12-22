package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

//优化
public class _03E2_2_8 {
    private static Double[] aux;

    public static void main(String[] args) {
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
    }

    public static void sort(Double[] a) {
        aux = new Double[a.length];  //比放在merge里面好很多, 不用new那么多个对象
        sort(a, 0, a.length - 1);
    }

    public static void sort(Double[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        if(SortUtil.less(a[mid+1],a[mid])){
            merge(a, lo, mid, hi);
        }
    }

    private static void merge(Double[] a, int lo, int mid, int hi) {
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
    }
}
