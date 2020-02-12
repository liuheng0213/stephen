package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

import java.util.Arrays;

public class _07LongestIncreasingSubSet_DP {
    public static void main(String[] args) {
        _07LongestIncreasingSubSet_DP longestIncreasingSubSet = new _07LongestIncreasingSubSet_DP();
        int[] arr = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        //int[] res = longestIncreasingSubSet.getLIS(arr);
        int[] res1 = longestIncreasingSubSet.getLISBetter(arr);
        //System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res1));
    }

    /**
     * o(n^2)
     * dp[a] = b 表示a 位置的arr[0..a] 的最长递增子序列长度为 b
     *
     * @param arr
     * @return
     */
    private int[] getLIS(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return getLIS(arr, dp);
    }

    /**
     * o(nlogn)
     *
     * @param arr
     * @return
     */
    private int[] getLISBetter(int[] arr) {
        int n = arr.length;
        int right = 0;
        //ends[b] = c 表示b 表示长度,C表示最小末尾
        int[] ends = new int[n];//ends[0.. right] 有效区, ends[right + 1 ...n - 1] 无效区;
        int[] dp = new int[n];

        ends[0] = arr[0];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {

            if (arr[i] > ends[right]) {
                ends[++right] = arr[i];
                dp[i] = right + 1;
            } else {
                int index = binarySearch(ends, 0, right, arr[i]);
                ends[index] = arr[i];
                dp[i] = index + 1;


            }
        }

        return getLIS(arr, dp);
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


    private int[] getLIS(int[] arr, int[] dp) {
        int maxIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        int n = dp[maxIndex];

        int[] lis = new int[n];
        lis[n - 1] = arr[maxIndex];
        int lisIndex = n - 2;
        int biggerIndex = maxIndex;
        for (int i = biggerIndex - 1; i >= 0; i--) {
            if (arr[i] < arr[biggerIndex] && dp[i] == dp[biggerIndex] - 1) {
                lis[lisIndex] = arr[i];
                lisIndex--;
                biggerIndex = i;
            }
            if (lisIndex < 0) {
                break;
            }
        }
        return lis;
    }

}
