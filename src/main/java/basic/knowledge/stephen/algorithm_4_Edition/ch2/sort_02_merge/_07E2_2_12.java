package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

//优化: 分割成多余2的chunk
public class _07E2_2_12 {

    public static int m = 14;//size of chunk

    public static void main(String[] args) {
        sort(MockData.INTEGER_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.INTEGER_FOR_SORT_MOCK);
    }

    public static void sort(Comparable[] a) {
        sort(a, new Integer[a.length], 0, a.length - 1);
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        int chunkNum = a.length % m == 0 ? a.length / m : a.length % m + 1;

        Integer[] primaryKeys = new Integer[chunkNum];

        for (int i = 0; i < chunkNum; i++) {
            if (i != chunkNum - 1) {
                selectSort(a, i * m,  i * m + m - 1);
            } else {
                selectSort(a, i * m, hi);
            }
            primaryKeys[i] = i * m;
        }

        //chunkNum=3    只用合并2次 此时的i指的合并次数
        for (int i = 1; i < chunkNum; i++) {
            if (SortUtil.less(a[primaryKeys[i]], a[primaryKeys[i] - 1])) {
                if (i != chunkNum - 1) {
                    merge(a, aux, 0, primaryKeys[i] - 1, primaryKeys[i] - 1 + m);
                } else {
                    merge(a, aux, 0, primaryKeys[i] - 1, hi);
                }
            }
        }
    }

    private static void selectSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            int min = i;
            for (int j = i + 1; j <= hi; j++) {
                if (SortUtil.less(a[j], a[min])) {
                    SortUtil.exch(a, j, min);
                }
            }
        }
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
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
