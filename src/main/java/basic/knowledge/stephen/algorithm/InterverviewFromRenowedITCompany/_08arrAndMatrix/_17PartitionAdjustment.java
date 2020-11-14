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

        int[] arr = new int[]{2, 0, 2, 0, 0, 1, 1, 2, 2, 2, 2, 1, 0};
        partitionAdjustment.sortCorrect(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 这是不行的 只能保证  0 ~lt-1  小于comaparable gt+1 ~end 大于comaparable lt gt =comaparable
     * 因此这种方法只能在arr[0] == 1 时使用
     * @param arr
     */
    private void sort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int lt = 0;
        int i = 1;
        int gt = arr.length - 1;
        int comaparable = arr[0];
        while (i <= gt) {
            if (comaparable > arr[i]) {
                swap(arr, lt, i);
                lt++;
                i++;
            } else if (comaparable < arr[i]) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }
    }


    private void sortCorrect(int[] arr) {
        int left = 0;
        int index = 0;
        int right = arr.length - 1;

        //如果按上面的设置 ,下面可以index <= right  如果
//        int left = -1;
//        int index = 0;
//        int right = arr.length;
        //则
//        while (index <= right) {
//            if (arr[index] == 0) {
//                swap(arr, ++left, index++);
//            } else if (arr[index] == 2) {
//                swap(arr, index, --right);
//            } else {
//                index++;
//            }
//        }
        //因为当 index == right 且进入到swap(arr, index, --right);  index < rignt 了 这种交换没有意义的
        while (index <= right) {
            if (arr[index] == 0) {
                swap(arr, left++, index++);
            } else if (arr[index] == 2) {
                swap(arr, index, right--);
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
