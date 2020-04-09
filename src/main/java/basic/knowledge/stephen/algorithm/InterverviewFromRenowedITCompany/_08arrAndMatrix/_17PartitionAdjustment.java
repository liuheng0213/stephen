package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.Arrays;

//数组的partition调整
//参考快速排序 快速排序partition point 的最优选择,大量重复元素的快速排序优化
public class _17PartitionAdjustment {
    public static void main(String[] args) {
        _17PartitionAdjustment partitionAdjustment = new _17PartitionAdjustment();
        /*int[] arr = new int[]{1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 8, 9, 9, 9, 9};
        int uIndex = partitionAdjustment.leftUni(arr);

        for (int i = 0; i <= uIndex; i++) {
            System.out.print(arr[i] + " ");
        }*/

        int[] arr = new int[]{1, 0, 2, 0, 0, 1, 1, 2, 2, 2, 2, 1, 0};
        partitionAdjustment.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        int left = -1;
        int index = 0;
        int right = arr.length;
        while (index < right) {
            if (arr[index] == 0) {
                swap(arr, ++left, index++);
            } else if (arr[index] == 2) {
                swap(arr, index, --right);
            } else {
                index++;
            }
        }
    }

    private int leftUni(int[] arr) {
        int u = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[u]) {
                swap(arr, ++u, i);
            }
        }
        return u;
    }


    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
