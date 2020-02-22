package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

public class _16GameOfFormingLineByCards_DP {
    public static void main(String[] args) {
        _16GameOfFormingLineByCards_DP gameOfFormingLineByCards = new _16GameOfFormingLineByCards_DP();
        int[] arr = new int[]{1, 2, 100, 4, 45, 3, 19, 200};
        int res = gameOfFormingLineByCards.win(arr);
        System.out.println(res);
    }

    /**
     * 这里双函数 不再是一个dp 而是f,s
     * dp[i][j]含义：
     * f(i,j) 会依赖于s(i+1,j) s(i.j-1)
     * s(i,j) 会依赖于f(i+1,j) f(i.j-1)
     * f,s 遍历中 所以可知 i 递减， j 递增
     * 且i <= j
     *
     * @param arr
     * @return
     */
    private int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];

        /**
         * i 虽然递减 但是要小于等于j
         */

        for (int i = arr.length - 1; i >= 0; i--) {
            f[i][i] = arr[i];
            for (int j = i + 1; j <= arr.length - 1; j++) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }
}
