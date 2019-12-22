package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.mock.MockData;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;

public class _09E2_1_25 {
    public static void main(String[] args) {
//        sort(MockData.DOUBLE_FOR_SORT_MOCK);
//        SortUtil.isSorted(MockData.DOUBLE_FOR_SORT_MOCK);

        Integer[] as = new Integer[]{4,3,5,2,6};
        sort(as);
        SortUtil.isSorted(as);
    }

    /**
     * 插入排序每一轮i  之前都是有序的, 利用这个
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable temp = arr[i];
            for (int j = i; j >0 ; j--) {
                if(SortUtil.less(temp, arr[j - 1])){
                    arr[j] = arr[j-1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
