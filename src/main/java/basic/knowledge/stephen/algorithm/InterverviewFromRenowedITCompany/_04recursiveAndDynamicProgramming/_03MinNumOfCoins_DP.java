package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

//组成零钱总数的方法数, 一共多少组合, -1 为没有组合的可能
public class _03MinNumOfCoins_DP {
    public static void main(String[] args) {
        _03MinNumOfCoins_DP minNumOfCoins_dp = new _03MinNumOfCoins_DP();
        int[] arr = {5, 2, 3};
        int aim = 20;
        int res = minNumOfCoins_dp.minCoins(arr, aim);
        System.out.println(res);
    }


    /**
     * 由递归法知 , 最终需要拿到dp[0][aim]
     * 一定要先知道左边和下边的值 才可以
     *
     * @param arr
     * @param aim
     * @return
     */
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
    private int minCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];

        for (int j = 1; j <= aim; j++) {
            dp[arr.length][j] = -1;
        }

        /**
         * 注意: == -1 时  不能进入min比较
         */
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -1;
                if (dp[i + 1][j] != -1) {
                    dp[i][j] = dp[i + 1][j];
                }

                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != -1) {
                    dp[i][j] = dp[i][j] == -1 ? dp[i][j - arr[i]] + 1 : Math.min(dp[i][j - arr[i]] + 1, dp[i][j]);
                }
            }
        }

        return dp[0][aim];
    }


}
