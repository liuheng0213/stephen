package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

public class _06MaxScoreOfChargingBalloon_DP {
    public static void main(String[] args) {
        _06MaxScoreOfChargingBalloon_DP maxScoreOfChargingBalloon = new _06MaxScoreOfChargingBalloon_DP();
        int[] arr = new int[]{3, 2, 5, 6};
        int[] help = new int[arr.length + 2];
        help[0] = 1;
        help[help.length - 1] = 1;
        for (int i = 0; i < arr.length; i++) {
            help[i + 1] = arr[i];
        }

        int N = help.length - 2;
        int row = help.length;
        int col = help.length;
        int[][] dp = new int[row][col];
        for (int i = 1; i <= N; i++) {
            dp[i][i] = help[i - 1] * help[i] * help[i + 1];
        }

        for (int i = N; i >= 1; i--) {  // left
            for (int j = i + 1; j <= N; j++) {  //right
                int max = 0;
                int res1 = dp[i + 1][j] + help[i - 1] * help[i] * help[j + 1];
                int res2 = dp[i][j - 1] + help[i - 1] * help[j] * help[j + 1];
                max = Math.max(res1, res2);
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(max, dp[i][k - 1] + dp[k + 1][j] + help[k] * help[i - 1] * help[j + 1]);
                }
                dp[i][j] = max;
            }
        }
        System.out.println(dp[1][N]);
    }

}
