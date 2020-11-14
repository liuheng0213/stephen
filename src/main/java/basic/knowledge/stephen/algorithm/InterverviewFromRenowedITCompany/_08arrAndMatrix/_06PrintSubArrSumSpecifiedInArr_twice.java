package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;


//不重复打印排序数组中相加和为给定值的所有二元组和三元组
public class _06PrintSubArrSumSpecifiedInArr_twice {
    public static void main(String[] args) {
        _06PrintSubArrSumSpecifiedInArr_twice obj = new _06PrintSubArrSumSpecifiedInArr_twice();
        int[] arr = new int[]{-8, -3, -3, 0, 1, 2, 4, 5, 8, 9};
        //obj.printUnqiuePair(arr, 10);
        obj.printUnqiueThree(arr, 10);
    }

    private void printUnqiueThree(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                printUnqiueThree(arr, i, i + 1, arr.length - 1, sum - arr[i]);
            }
        }
    }

    private void printUnqiueThree(int[] arr, int i, int left, int right, int sum) {
        while (left < right) {
            if(arr[left] + arr[right] == sum){
                if(left == i + 1 || arr[left] != arr[left - 1]){
                    System.out.println(arr[i] + "==" + arr[left] + "===" + arr[right]);
                }
                left++;
                right--;
            }else if(arr[left] + arr[right] < sum){
                left++;
            }else{
                right--;
            }
        }
    }

    private void printUnqiuePair(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;

        //贪心算法,只专注于当前
        while (left < right) {
            if (arr[left] + arr[right] == sum) {
                if (left == 0 || arr[left] != arr[left - 1]) {
                    System.out.println(arr[left] + "----" + arr[right]);
                }
                left++;
                right--;
            } else if (arr[left] + arr[right] > sum) {
                right--;
            } else {
                left++;
            }
        }
    }
}
