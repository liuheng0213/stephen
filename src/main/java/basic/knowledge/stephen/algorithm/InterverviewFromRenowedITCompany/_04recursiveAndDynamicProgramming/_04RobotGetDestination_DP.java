package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _04RobotGetDestination_DP {
    public static void main(String[] args) {
        _04RobotGetDestination_DP robotGetDestination = new _04RobotGetDestination_DP();
        int res = robotGetDestination.ways(5, 4, 5, 3);
        int res1 = robotGetDestination.ways1(5, 4, 5, 3);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res == res1);
    }



    /**
     * @param N 排成一行的N哥位置  固定值
     * @param M 开始时的位置 递归里的当前位置
     * @param K 机器人必须走K步  递归里的剩余步数
     * @param P 最后停下来的位置  固定值
     * @return
     *
     *   dp[i][j] = dp[i + 1][j - 1] + dp[i - 1][j - 1];
     *   故一定要先遍历列
     */
    private int ways(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }

        //dp[i][j] 为 当前i 位置 剩下j个步伐 的情况下 值为路线方法总数
        int[][] dp = new int[N + 1][K + 1];
        dp[P][0] = 1;
        for (int j = 1; j <= K; j++) {//int j = 1; j <= K; j++
            for (int i = 1; i <= N; i++) {
                if (i == N) {
                    dp[i][j] = dp[N - 1][j - 1];
                } else if (i == 1) {
                    dp[i][j] = dp[2][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] + dp[i - 1][j - 1];
                }


                //一样的
              /*  if (i == 1) {
                    dp[i][j] = dp[2][j - 1];
                } else if (i == N) {
                    dp[i][j] = dp[N - 1][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] + dp[i - 1][j - 1];
                }*/
            }
        }
        return dp[M][K];

    }

    /**
     * *   dp[i][j] = dp[i + 1][j - 1] + dp[i - 1][j - 1];
     *   故一定要先遍历列
     *   // 这一点我过去疏忽了 ,  行列遍历也有先后之分, 并不只是索引大小之分
     * @param N
     * @param M
     * @param K
     * @param P
     * @return
     */
    private int ways1(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }

        //dp[i][j] 为 当前i 位置 剩下j个步伐 的情况下 值为路线方法总数
        int[][] dp = new int[N + 1][K + 1];
        dp[P][0] = 1;
        for (int j = 1; j <= K; j++) {//int j = 1; j <= K; j++
            for (int i = N; i >= 1; i--) {
                if (i == N) {
                    dp[i][j] = dp[N - 1][j - 1];
                } else if (i == 1) {
                    dp[i][j] = dp[2][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[M][K];
    }
}
