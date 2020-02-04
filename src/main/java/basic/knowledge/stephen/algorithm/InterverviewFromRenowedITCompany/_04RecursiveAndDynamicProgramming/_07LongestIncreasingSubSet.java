package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

import java.util.Arrays;

public class _07LongestIncreasingSubSet {
    public static void main(String[] args) {
        _07LongestIncreasingSubSet longestIncreasingSubSet = new _07LongestIncreasingSubSet();
        int[] arr = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] res = longestIncreasingSubSet.getLIS(arr);
        System.out.println(Arrays.toString(res));
    }

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
                i = biggerIndex - 1;
            }
            if (lisIndex < 0) {
                break;
            }

        }
        return lis;
    }

}
