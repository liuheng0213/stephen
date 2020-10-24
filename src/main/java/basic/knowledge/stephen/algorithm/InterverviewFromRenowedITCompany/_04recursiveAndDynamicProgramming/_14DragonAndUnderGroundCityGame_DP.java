package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;


//龙与地下城游戏
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
     * 如果骑士从i,j 开始选择最优路径且确定能走到 右下角 所需最少血量(即未加m[i][j])
     * 返回就dp[0][0]
     *
     * @param m
     * @return
     */
    private int minHP(int[][] m) {

        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row--][col--];
        //上一个数(dp[row -1 ][col]或 dp[row][col - 1])加过来


        //首先  原则: 从右下角出来时 必有血量>= 1  倒推dp[row][col]
        //dp[i][j] + m[i][j] = dp[i + 1][j]   or dp[i][j+ 1]
        //dp[row][col] + m[row][col]  >= 1  m[row][col]  <=0 时  可形成 1 (dp[row][col] >=  1 - m[row][col] 最小值为  1 - m[row][col])
        //m[row][col]  > 0 时   dp[row][col] >= 1 - m[row][col] 又因为 dp[row][col] >= 1  故 dp[row][col] 最小值为 1
        dp[row][col] = m[row][col] > 0 ? 1 : 1 - m[row][col];
        for (int j = col - 1; j >= 0; j--) {
            dp[row][j] = Math.max(dp[row][j + 1] - m[row][j], 1);//row  not 0 贴着最下一行走就只能往右了
        }

        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(dp[i + 1][col] - m[i][col], 1);
        }

        int right = 0;
        int down = 0;

        //切不可 为row - 2  否则漏掉了一个  上述的两个循环的row col 已经是索引位了  而不是长度
        // dp 题一定要小心阿
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                down = Math.max(dp[i + 1][j] - m[i][j], 1);
                right = Math.max(dp[i][j + 1] - m[i][j], 1);
                dp[i][j] = Math.min(down,right);
            }
        }
        return dp[0][0];



    }
}
