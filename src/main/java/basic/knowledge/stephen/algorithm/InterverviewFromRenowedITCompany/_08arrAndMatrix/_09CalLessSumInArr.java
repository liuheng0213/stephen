package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

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

    private int fun(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) >> 1;
        return fun(arr, left, mid) + fun(arr, mid + 1, right) + merge(arr, left, mid, right);
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

    private int merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int smallSum = 0;

        for (int k = left; k <= right; k++) {
            auxArr[k] = arr[k];
        }

        //放回arr
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = auxArr[j++];
            } else if (j > right) {
                arr[k] = auxArr[i];
                i++;
            } else if (auxArr[i] <= auxArr[j]) {
                smallSum += auxArr[i] * (right - j + 1);
                arr[k] = auxArr[i++];
            } else {
                arr[k] = auxArr[j++];
            }
        }
        return smallSum;
    }
}
