package basic.knowledge.stephen.algorithm.leetcode.dynamic_programming;

/**
 * 最长递增序列
 */
public class LongestIncreasingSubArr {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7, 8, 9, 10, 13, 4, 6};
        //int res = getLongest(arr, 1); //动态规划法
        //System.out.println(res);
        //int res2 = getLongestBetter(arr, 1);
        //System.out.println(res2);

        for (int i = 1; i <= arr.length; i++) {
            System.out.println(getLongest(arr, i) == getLongestBetter(arr, i));
        }
    }

    /**
     * 构建数组B 记录最小末尾
     * B的索引记录子数组的长度,B的值记录该长度的在arr中的最小值
     *
     * @param arr
     * @param n
     * @return
     */
    private static int getLongestBetter(int[] arr, int n) {
        int[] B = new int[n];
        if (B.length == 1) {
            return 1;
        }
        int j = 1;
        for (int i = 0; i < n; i++) {
            int index = binarySearch(B, 0, j, arr[i]);
            if (index > j) {
                B[j] = arr[i];
                j++;
            } else {
                B[index] = arr[i];
            }
        }
        return j - 1;
    }

    private static int binarySearch(int[] B, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (B[mid] == target) {
                return mid;
            } else if (B[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


    /**
     * 动态规划法  d 数组 保留每一个的值
     * o(n^2)
     *
     * @param arr
     * @param n
     */
    public static int getLongest(int[] arr, int n) {
        //存放状态
        int[] d = new int[n];
        //最长非降子序列长度初始化为1
        int length = 1;
        //状态初始化为1
        d[0] = 1;
        for (int i = 1; i < n; i++) {
            //状态初始化为1  zz
            d[i] = 1;//自己算一个 G D
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
                if (length < d[i]) {
                    length = d[i];
                }
            }
        }
        return length;

    }

}
