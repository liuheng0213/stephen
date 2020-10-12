package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;


//从0,0 走到  对角尽头 ,最小的路径和是多少
public class _02MinSumOfPath_DP {
    public static void main(String[] args) {
        _02MinSumOfPath_DP minSumOfPath = new _02MinSumOfPath_DP();
        int[][] arr = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int res = minSumOfPath.getRes1(arr);
        int res1 = minSumOfPath.getRes(arr);
        System.out.println(res1);
    }

    /**
     * 空间压缩
     * y @param arr
     *
     * @return
     */
    private int getRes1(int[][] arr) {
        int more = Math.max(arr.length, arr[0].length);
        int less = Math.min(arr.length, arr[0].length);
        boolean rowMore = more == arr.length;//行数是否大于列数
        int[] dp = new int[less];
        dp[0] = arr[0][0];
        // 先初始化第一行
        for (int j = 1; j < less; j++) {
            dp[j] = dp[j - 1] + (rowMore ? arr[0][j] : arr[j][0]);
        }

        for (int i = 1; i < more; i++) {// 从第I行开始  dp[0] 要重新赋值
            dp[0] = dp[0] + (rowMore ? arr[i][0] : arr[0][i]);
            for (int j = 1; j < less; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + (rowMore ? arr[i][j] : arr[j][i]);
            }
        }
        return dp[less - 1];

    }

    private int getRes(int[][] arr) {
        if (arr == null || arr[0] == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[arr.length][arr[0].length];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }

        return dp[arr.length - 1][arr[0].length - 1];
    }
}
