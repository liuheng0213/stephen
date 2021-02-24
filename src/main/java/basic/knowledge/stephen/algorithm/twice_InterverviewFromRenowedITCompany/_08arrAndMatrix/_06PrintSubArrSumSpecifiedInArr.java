package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._08arrAndMatrix;

//不重复打印排序数组中相加和为给定值的所有二元组和三元组
public class _06PrintSubArrSumSpecifiedInArr {
    public static void main(String[] args) {
        _06PrintSubArrSumSpecifiedInArr printSubArrSumSpecifiedInArr = new _06PrintSubArrSumSpecifiedInArr();
        int[] arr = new int[]{-8, -3, -3, 0, 1, 2, 4, 5, 8, 9};
        //printSubArrSumSpecifiedInArr.printUnqiuePair(arr, 10);
        printSubArrSumSpecifiedInArr.printUnqiueThree(arr, 10);
    }

    private void printUnqiueThree(int[] arr, int k) {
        if (arr == null || arr.length < 3) {
            return;

        }
        for (int i = 0; i < arr.length - 2; i++) { //i < arr.length - 2 至少要留两个在后面
            if (i == 0 || arr[i - 1] != arr[i]) {
                printUnqiueThree(arr, i, i + 1, arr.length - 1, k - arr[i]);
            }
        }
    }

    private void printUnqiueThree(int[] arr, int i, int left, int right, int k) {
        while (left < right) {
            if (arr[left] + arr[right] == k) {
                if (left == i + 1 || arr[left] != arr[left - 1]) {
                    System.out.println(arr[i] + ", " + arr[left] + ", " + arr[right]);
                }
                left++;
                right--;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                left++;
            }
        }
    }

    private void printUnqiuePair(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;

        //贪心算法,只专注于当前
        while (left < right) {
            if (arr[left] + arr[right] == k) {
                if (left > 0 && arr[left] != arr[left - 1]) {
                    System.out.println(arr[left] + ", " + arr[right]);
                }
                left++;
                right--;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                left++;
            }
        }

        //这种快慢指针题  要用while  用for 语义不明
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[left] + arr[right] == k) {
//                if (left > 0 && arr[left] != arr[left - 1]) {
//                    System.out.println(arr[left] + ", " + arr[right]);
//                }
//                left++;
//                right--;
//            } else if (arr[left] + arr[right] > k) {
//                right--;
//            } else {
//                left++;
//            }
//        }

    }
}
