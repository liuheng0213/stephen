package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.Arrays;

//自然数数组的排序
//长度为N的数组数组元素为互不相等的1~N,实现排序
public class _10NaturalNumSorting {
    public static void main(String[] args) {
        _10NaturalNumSorting naturalNumSorting = new _10NaturalNumSorting();
        int[] arr = {3, 4, 7, 8, 6, 1, 5, 2};
        naturalNumSorting.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            while (arr[i] != i + 1) {
                temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
