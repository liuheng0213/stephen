package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

/**
 * 自然的归并排序
 */
public class _10E2_2_16 {
    public static void main(String[] args) {
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
    }


    public static void sort(Double[] a) {
        int n = a.length;

        //创建标记数组
        Integer[] mark = new Integer[a.length];
        adjustMark(a, mark);

        for (int i = 0; i < mark.length / 2; i++) {//首轮合并次数
            for (int j = 0; j < n - mark.length; j += 2) {
                merge(a, new Double[a.length], mark[j], mark[j + 1] - 1, mark[j + 2] - 1);
            }
            adjustMark(a, mark);
        }

    }

    private static void adjustMark(Double[] a, Integer[] mark) {
        int j = 0;
        mark[j++] = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (SortUtil.less(a[i + 1], a[i])) {
                mark[j++] = i + 1;//mark[j++]标记合并子数组大小,且索引标记合并子数组的首索引
            }
        }
    }


    private static void merge(Double[] a, Double[] aux, int lo, int mid, int hi) {
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
