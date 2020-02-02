package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

public class _03MinNumOfCoins_DP {
    public static void main(String[] args) {
        _03MinNumOfCoins_DP minNumOfCoins_dp = new _03MinNumOfCoins_DP();
        int[] arr = {3, 5};
        int aim = 2;
        int res = minNumOfCoins_dp.minCoins(arr, aim);
        System.out.println(res);
    }

    private int minCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return dp(arr, aim);
    }

    /**
     * 由递归法知 , 最终需要拿到dp[0][aim]
     * 一定要先知道左边和下边的值 才可以
     *
     * @param arr
     * @param aim
     * @return
     */
    private int dp(int[] arr, int aim) {
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];

        dp[n][0] = 0;
        for (int i = 1; i <= aim; i++) {
            dp[n][i] = -1;
        }

        /**
         * 根据书中分析:
         * dp[i][rest]
         * 要么等于
         * dp[i + 1][rest]
         * 要么等于
         * dp[i][rest - arr[i]] + 1)
         * 要么等于
         * dp[i][rest] = Math.min(dp[i + 1][rest], dp[i][rest - arr[i]] + 1);
         */
        for (int i = n - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[i][rest] = -1;
                if (dp[i + 1][rest] == -1) {
                    if (rest >= arr[i] && dp[i][rest - arr[i]] != -1) {
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    }
                } else {
                    if (rest >= arr[i] && dp[i][rest - arr[i]] != -1) {
                        dp[i][rest] = Math.min(dp[i + 1][rest], dp[i][rest - arr[i]] + 1);
                    } else {
                        dp[i][rest] = dp[i + 1][rest];
                    }
                }
            }
        }
        return dp[0][aim];
    }
}
