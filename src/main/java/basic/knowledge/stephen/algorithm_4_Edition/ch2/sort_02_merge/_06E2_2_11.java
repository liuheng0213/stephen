package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_02_merge;

import basic.knowledge.stephen.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

//优化:1 加快排序,小数组的排序(size<15),既小数组不归并,2 检测数组是否有序, 以及通过在递归中交换参数来避免复制数组
public class _06E2_2_11 {

    public static void main(String[] args) {
        sort(MockData.DOUBLE_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);
    }

    public static void sort(Double[] input) {
        Double[] source = input.clone();
        sort(source, input, 0, input.length - 1);
    }

    public static void sort(Double[] src ,Double[] des ,int lo, int hi) {
        if (hi - lo <=15) {
            insertSort(des,lo,hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        //src 在lo~mid是有序的,
        sort(des, src, lo, mid);
        //src 在mid + 1~hi是有序的,
        sort(des, src, mid + 1, hi);
        if (SortUtil.less(src[mid + 1], src[mid])) {
            merge(des, src, lo, mid, hi);
        }
    }

    private static void insertSort(Double[] des, int lo, int hi) {
        for(int i = lo + 1; i <= hi; i++) {
            for(int j = i; j > lo && SortUtil.less(des[j], des[j-1]); j--) {
                SortUtil.exch(des, j, j-1);
            }
        }
    }

    private static void merge(Double[] des, Double[] src, int lo, int mid, int hi) {


        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                des[k] = src[j++];
            } else if (j > hi) {
                des[k] = src[i++];
            } else if (SortUtil.less(src[j], src[i])) {
                des[k] = src[j++];
            } else {
                des[k] = src[i++];
            }
        }


    }
}
