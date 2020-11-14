package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.Arrays;

//要么奇数下标都是奇数,要么偶数下标都是偶数  注意是要么 either or
public class _11EvenOddIndexSuitsEle {
    public static void main(String[] args) {
        _11EvenOddIndexSuitsEle evenOddIndexSuitsEle = new _11EvenOddIndexSuitsEle();
        int[] arr = new int[]{1, 8, 3, 2, 4, 6};
        evenOddIndexSuitsEle.modify(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void modify(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int odd = 1;
        int even = 0;
        int end = arr.length - 1;
        while (odd <= end && even <= end) {
            if ((arr[end] & 1) == 0) {
                swap(arr, even, end);
                even += 2;
            } else {
                swap(arr, odd, end);
                odd += 2;
            }
        }
        return;
    }

    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
