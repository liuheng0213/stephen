package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._08arrAndMatrix;

//计算数组的小和
public class _09CalLessSumInArr {
    public static int[] auxArr;

    public static void main(String[] args) {
        _09CalLessSumInArr calLessSumInArr = new _09CalLessSumInArr();
        int[] arr = new int[]{3, 1, 5, 4, 2, 6, 8, 2, 13};
        auxArr = new int[arr.length];
        int res = calLessSumInArr.fun(arr, 0, arr.length - 1);
        System.out.println(res);
    }

    private int fun(int[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) >> 1;
        return fun(arr, start, mid) + fun(arr, mid + 1, end) + mergeBetter(arr, start, mid, end);
    }
    private int mergeBetter(int[] arr, int left, int mid, int right) {
        int[] h = new int[right - left + 1];
        int hi = 0;
        int i = left;
        int j = mid + 1;
        int smallSum = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                smallSum += arr[i] * (right - j + 1);
                h[hi++] = arr[i++];
            } else {
                h[hi++] = arr[j++];
            }
        }
        //此时 要么 i  = mid + 1要么 j = right + 1  两者二选一
        for (; (j < right + 1) || (i < mid + 1); j++, i++) {
            h[hi++] = i > mid ? arr[j] : arr[i];
        }

        //复制给arr
        for (int k = 0; k != h.length; k++) {
            arr[left++] = h[k];
        }
        return smallSum;
    }

    private int merge(int[] arr, int start, int mid, int end) {
        auxArr = new int[arr.length];
        for (int k = start; k <= end; k++) {
            auxArr[k] = arr[k];
        }

        int i = start;
        int j = mid + 1;

        int smallSum = 0;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                arr[k] = auxArr[j++];
            } else if (j > end) {
                arr[k] = auxArr[i++];
            } else if (auxArr[i] <= auxArr[j]) {
                smallSum += auxArr[i] * (end - j + 1);
                arr[k] = auxArr[i++];
            } else {
                arr[k] = auxArr[j++];
            }
        }
        return smallSum;
    }


}
