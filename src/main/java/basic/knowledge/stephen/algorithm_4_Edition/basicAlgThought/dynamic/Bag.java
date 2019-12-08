package basic.knowledge.stephen.algorithm_4_Edition.basicAlgThought.dynamic;

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
        int[] w = {2, 3, 4, 5};//商品重量
        int[] v = {3, 4, 5, 6};//商品的价值

        int bagV = 8;//包能承受的最大重量
        int result = solution(w, v, bagV);
        System.out.println(result);


        // find increasing path

    }

    private static int solution(int[] w, int[] v, int bagV) {
        w = new int[]{0, 2, 3, 4, 5};
        v = new int[]{0, 3, 4, 5, 6};

        //dp 添加商品时, 包重量增加的路径
        int[][] dp = new int[w.length][bagV + 1];//注意行列各是多少
        for (int i = 1; i <= w.length - 1; i++) {
            for (int j = 1; j <= bagV; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }


        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < bagV + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[w.length - 1][bagV];
    }
}
