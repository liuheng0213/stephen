package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _05MethodOfMoneyChange_DP {
    public static void main(String[] args) {
        _05MethodOfMoneyChange_DP obj = new _05MethodOfMoneyChange_DP();
        int[] arr = new int[]{5, 10, 25, 1, 100, 50};
        int methods = obj.getRes(arr, 35);
        int methods1 = obj.getRes2(arr, 35);
        System.out.println(methods);
        System.out.println(methods1);
    }

    //dp含义 dp[i][j] 为0~i , 组成aim共几种方法
    private int getRes2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int n = arr.length;

        //返回 dp[n - 1][aim]
        int[][] dp = new int[n][aim + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i * arr[0] <= aim; i++) {
            dp[0][i * arr[0]] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - arr[i] >= 0) {
                    dp[i][j] += dp[i][j - arr[i]];
                }
            }
        }
        return dp[n - 1][aim];
    }

    //dp含义 dp[i][j] 为只用i~arr.length索引上的纸币, 组成aim共几种方法
    private int getRes(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int n = arr.length;

        //dp含义 dp[i][j] 为只用i~arr.length - 1索引上的纸币, 组成aim共几种方法
        int[][] dp = new int[n + 1][aim + 1];

        dp[n][0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                if (j - arr[i] >= 0) {
                    dp[i][j] = dp[i][j - arr[i]] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];//i 这个钞票 一张都没用
                }
            }
        }

        return dp[0][aim];
    }


}
