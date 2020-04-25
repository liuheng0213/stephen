package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _05MethodOfMoneyChange_DP {
    public static void main(String[] args) {
        _05MethodOfMoneyChange_DP methodOfMoneyChange_dp = new _05MethodOfMoneyChange_DP();
        int[] arr = new int[]{5, 10, 25, 1};
        int methods = methodOfMoneyChange_dp.getRes1(arr, 0);
        System.out.println(methods);
    }

    /**
     * o(n * aim)
     * @param arr
     * @param aim
     * @return
     */
    private int getRes1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        for (int i = 0; i <= aim; i++) {
            if (i == 0) {
                dp[n][i] = 1;
            } else {
                dp[n][i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        //k 从大到小  aim 从小到大
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 1; rest <= aim; rest++) {
//                int num = 0;
//                for(int k = 0;k * arr[index] <= rest;k++){
//                    num += dp[index + 1][rest - k * arr[index]];
//                }
                dp[index][rest] = dp[index + 1][rest];
                dp[index][rest] += rest - arr[index] >= 0 ? dp[index][rest - arr[index]] : 0;
            }
        }
        return dp[0][aim];
    }

    /**
     * o (n * aim^2)
     *
     * @param arr
     * @param aim
     * @return
     */
    private int getRes(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        for (int i = 0; i <= aim; i++) {
            if (i == 0) {
                dp[n][i] = 1;
            } else {
                dp[n][i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        //k 从大到小  aim 从小到大
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 1; rest <= aim; rest++) {
                int num = 0;
                for (int k = 0; k * arr[index] <= rest; k++) {
                    num += dp[index + 1][rest - k * arr[index]];
                }
                dp[index][rest] = num;
            }
        }
        return dp[0][aim];
    }
}
