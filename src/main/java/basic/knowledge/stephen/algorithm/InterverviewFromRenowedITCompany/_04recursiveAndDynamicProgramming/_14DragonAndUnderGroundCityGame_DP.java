package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _14DragonAndUnderGroundCityGame_DP {
    public static void main(String[] args) {
        _14DragonAndUnderGroundCityGame_DP dragonAndUnderGroundCityGame = new _14DragonAndUnderGroundCityGame_DP();
        int[][] m = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {0, 30, -5}};
        int res = dragonAndUnderGroundCityGame.minHP(m);
        System.out.println(res);
    }

    /**
     * 走到任何一个位置血量不能小于1
     * dp[i][j] 含义:
     * 如果骑士走到i,j 从该位置选择一条最优路径最后走到最下角,起码应该具备的血量
     *
     * @param m
     * @return
     */
    private int minHP(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row--][col--];
        //base case 求解推导
        // 应保证 dp[row][col] =  x + m[row][col] 满足条件(即x + m[row][col]>= 1),且x最小;x 来自上边 或左边
        //要使得x + m[row][col] 尽量小 但要>= 1
        // 所以 if m[row][col] > 0 则 x 应尽量小 且满足 x + m[row][col] = 1 为好
        // if  m[row][col] <=  0  => x + m[row][col] <= 1 <= x
        dp[row][col] = m[row][col] > 0 ? 1 : 1 - m[row][col];
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(1, dp[i + 1][col] - m[i][col]);
        }


        //可以放如双层循环中
        for (int j = col - 1; j >= 0; j--) {
            dp[row][j] = Math.max(1, dp[row][j + 1] - m[row][j]);
        }
        int down = 0;
        int right = 0;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                down = Math.max(1, dp[i + 1][j] - m[i][j]);
                right = Math.max(1, dp[i][j + 1] - m[i][j]);
                dp[i][j] = Math.min(right,down);
            }
        }
        return dp[0][0];
    }
}
