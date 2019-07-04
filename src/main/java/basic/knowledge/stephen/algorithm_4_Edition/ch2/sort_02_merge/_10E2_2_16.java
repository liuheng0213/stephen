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

        int j = 1;
        mark[0] = 0;
        for(int i = 0;i<a.length;i++){
            if(SortUtil.less(a[i+1],a[i])){
                mark[j++]= i;
            }

        }
        

        for (int size = 1; size < n; size *= 2) {
            for (int index = 0; index <n-size; index = 2 * size + index) {//index <n-size 一定要考虑最后有可能出现size merge 1的情况
                merge(a,new Double[a.length],index,size+index-1 , Math.min(2 * size + index -1, n-1));
            }
        }
    }


    private static void merge(Double[] a,Double[] aux, int lo, int mid, int hi) {
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
