package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.Arrays;

//奇数下标都是奇数,偶数下标都是偶数
public class _11EvenOddIndexSuitsEle {
    public static void main(String[] args) {
        _11EvenOddIndexSuitsEle evenOddIndexSuitsEle = new _11EvenOddIndexSuitsEle();
        int[] arr = new int[]{1, 8, 3, 2, 4, 6};
        evenOddIndexSuitsEle.modify(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void modify(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int odd = 1;
        int even = 0;
        int end = arr.length - 1;

        //凡是循环里没用到i的一律用while循环, 更直观
      /*  for (int i = 0; i <= end; i++) {
            if (arr[end] % 2 == 0) {
                swap(arr, even, end);
                even += 2;
            } else {
                swap(arr, odd, end);
                odd += 2;
            }
            if (odd > end || even > end) {
                break;
            }
        }*/
        while (even <= end && odd <= end) {
            if (arr[end] % 2 == 0) {
                swap(arr, even, end);
                even += 2;
            } else {
                swap(arr, odd, end);
                odd += 2;
            }
        }
    }

    private void swap(int[] arr, int even, int end) {
        int temp = arr[even];
        arr[even] = arr[end];
        arr[end] = temp;
    }
}
