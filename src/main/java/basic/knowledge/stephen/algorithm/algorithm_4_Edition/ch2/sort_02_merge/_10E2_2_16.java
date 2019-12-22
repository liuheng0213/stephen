package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

/**
 * 优化: 自然的归并排序
 */
public class _10E2_2_16 {
    public static void main(String[] args) {
        System.out.println(MockData.DOUBLE_FOR_SORT_MOCK.length);
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
        System.out.println(MockData.DOUBLE_FOR_SORT_MOCK.length);
    }


    public static void sort(Double[] a) {
        int n = a.length;

        //创建标记数组
        Integer[] mark = new Integer[n];
        int markLength = adjustMark(a, mark);

        while(markLength != 1){
            if(markLength == 2){
                merge(a, new Double[n], mark[0],mark[1] -1 ,n-1 );
            }
            for (int j = 0; j < markLength -2; j += 2) {
                merge(a, new Double[a.length], mark[j], mark[j + 1] - 1, mark[j + 2] - 1);
            }
            mark = new Integer[markLength];
            markLength = adjustMark(a, mark);
        }

    }

    private static int adjustMark(Double[] a, Integer[] mark) {
        int j = 0;
        mark[j++] = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (SortUtil.less(a[i + 1], a[i])) {
                mark[j++] = i + 1;//mark[j++]标记下一个子数组的首索引,J标记合并子数组的总数量
            }
        }
        return j;
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
