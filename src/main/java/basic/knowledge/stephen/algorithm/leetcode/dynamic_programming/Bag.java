package basic.knowledge.stephen.algorithm.leetcode.dynamic_programming;

/**
 * 有n个物品，它们有各自的体积和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？
 * <p>
 * <p>
 * 寻找递推关系式，面对当前商品有两种可能性：
 * <p>
 * 包的容量比该商品体积小，装不下，此时的价值与前i-1个的价值是一样的，即V(i,j)=V(i-1,j)；
 * 还有足够的容量可以装该商品，但装了也不一定达到当前最优价值，
 * 所以在装与不装之间选择最优的一个，即V(i,j)=max｛V(i-1,j)，V(i-1,j-w(i))+v(i)｝。
 */
public class Bag {
    public static void main(String[] args) {
        int[] w = {2, 3, 4, 4};//商品重量  i 代表 w的索引
        int[] v = {3, 4, 5, 6};//商品的价值

        int totalWeight = 8;//包能承受的最大重量  j 代表包的重量
        int result = solutionDp(w, v, totalWeight);
        System.out.println(result);

    }

    private static int solutionDp(int[] w, int[] v, int totalWeight) {
        //dp 添加商品时, 包重量增加的路径
        //dp[0][v] = MAXinteger dp[w][0] = 0
        int[][] dp = new int[w.length][totalWeight + 1];
        for (int j = 0; j < dp[0].length; j++) {
            if (j < w[0]) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = v[0];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        return dp[w.length - 1][totalWeight];
    }
}
