package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

public class _02MinSumOfPath {
    public static void main(String[] args) {
        _02MinSumOfPath minSumOfPath = new _02MinSumOfPath();
        int[][] arr = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int res = minSumOfPath.getRes(arr);
        System.out.println(res);
    }

    private int getRes(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }

        for (int i = 1; i < arr[0].length; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
