package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

public class _12MinEditCost_DP {
    public static void main(String[] args) {
        _12MinEditCost_DP minEditCost = new _12MinEditCost_DP();
        String str1 = "abc";
        String str2 = "adc";
        int res = minEditCost.minCost(str1, str2, 5, 3, 100);
        System.out.println(res);
    }

    /**
     * dp[i][j] 表示str1[0..i] ----> str2[0...j]的代价 这样表示不行 因为str1[ i -1]表示不了 base case
     * dp[i][j] 表示str1[0..i - 1] ----> str2[0...j - 1]的代价
     *
     * @param str1
     * @param str2
     * @param ic
     * @param dc
     * @param rc
     * @return
     */
    private int minCost(String str1, String str2, int ic, int dc, int rc) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int row = chars1.length + 1;
        int col = chars2.length + 1;
        int[][] dp = new int[row][col];
        //base case
        for (int i = 1; i < row; i++) {
            dp[i][0] = i * dc;
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = j * ic;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);//i删末尾  再dp[i -1][j]
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
            }
        }
        return dp[row - 1][col - 1];
    }
}
