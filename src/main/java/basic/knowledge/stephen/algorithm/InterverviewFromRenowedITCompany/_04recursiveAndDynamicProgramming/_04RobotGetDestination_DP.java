package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _04RobotGetDestination_DP {
    public static void main(String[] args) {
        _04RobotGetDestination_DP robotGetDestination = new _04RobotGetDestination_DP();
        int res = robotGetDestination.ways2(5, 2, 3, 3);
        System.out.println(res);
    }

    /**
     * 为什么这个有问题
     * 谁做行对应,谁做列对应 无所谓
     * 我这个不对 ,
     *  dp[cur][rest] = dp[2][rest - 1];
     *  这个 求dp[1][rest], dp[2][rest - 1]么有赋值
     * @param N
     * @param M
     * @param K
     * @param P
     * @return
     */
    private int ways2(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[N + 1][K + 1];
        dp[P][0] = 1;
        for (int cur = 1; cur <= N; cur++) {
            for (int rest = 1; rest <= K; rest++) {
                if (cur == 1) {
                    dp[cur][rest] = dp[2][rest - 1];
                } else if (cur == N) {
                    dp[cur][rest] = dp[N - 1][rest - 1];
                } else {
                    dp[cur][rest] = dp[cur + 1][rest - 1] + dp[cur - 1][rest - 1];
                }
                System.out.print(dp[cur][rest] + " ");
            }
            System.out.println();
        }
      /*  for (int rest = 1; rest <= K; rest++) {
            for (int cur = 1; cur <= N; cur++) {
                if (cur == 1) {
                    dp[rest][cur] = dp[rest - 1][2];
                } else if (cur == N) {
                    dp[rest][cur] = dp[rest - 1][N - 1];
                } else {
                    dp[rest][cur] = dp[rest - 1][cur + 1] + dp[rest - 1][cur - 1];
                }
            }
        }*/
        return dp[M][K];
    }

    /**
     * @param N 排成一行的N哥位置  固定值
     * @param M 开始时的位置 递归里的当前位置
     * @param K 机器人必须走K步  递归里的剩余步数
     * @param P 最后停下来的位置  固定值
     * @return
     */
    private int ways(int N, int M, int K, int P) {
        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;
        for (int rest = 1; rest <= K; rest++) {
            for (int cur = 1; cur <= N; cur++) {
                if (cur == 1) {
                    dp[rest][cur] = dp[rest - 1][2];
                } else if (cur == N) {
                    dp[rest][cur] = dp[rest - 1][N - 1];
                } else {
                    dp[rest][cur] = dp[rest - 1][cur + 1] + dp[rest - 1][cur - 1];
                }
                System.out.print(dp[rest][cur] + " ");
            }
            System.out.println();
        }
        return dp[K][M];


    }

    private int ways1(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][N - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[K][M];
    }
}
