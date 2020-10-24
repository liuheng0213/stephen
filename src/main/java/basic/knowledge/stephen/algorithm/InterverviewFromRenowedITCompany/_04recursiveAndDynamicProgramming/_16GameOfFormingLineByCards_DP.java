package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;


//排成一条线的纸牌博弈问题 DP法
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
     * first(i,j) 会依赖于last(i+1,j) last(i.j-1)
     * last(i,j) 会依赖于first(i+1,j) first(i.j-1)
     * first,last 遍历中 所以可知 i 递减， j 递增
     * 且i <= j
     *
     * @param arr
     * @return
     */
    private int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] first = new int[arr.length][arr.length];
        int[][] last = new int[arr.length][arr.length];

        for (int i = first.length - 2; i >= 0; i--) {
            first[i][i] = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                first[i][j] = Math.max(arr[i] + last[i + 1][j], arr[j] + last[i][j - 1]);
                last[i][j] = Math.min(first[i + 1][j],first[i][j - 1]);
            }
        }
        return Math.max(first[0][first[0].length - 1],last[0][first[0].length - 1]);


    }
}
