package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;


//最小编辑代价
public class _12MinEditCost_DP {
    public static void main(String[] args) {
        _12MinEditCost_DP minEditCost = new _12MinEditCost_DP();
        String str1 = "abc";
        String str2 = "adc";
        int res = minEditCost.minCost(str1, str2, 5, 3, 3);
        System.out.println(res);
    }

    /**
     * dp[i][j] 表示str1[0..i] ----> str2[0...j]的代价 这样表示不行 因为str1[ i -1]表示不了 base case
     * dp[i][j] 表示str1[0..i - 1] ----> str2[0...j - 1]的代价  correct.
     *
     * @param str1
     * @param str2
     * @param ic
     * @param dc
     * @param rc
     * @return
     */
    private int minCost(String str1, String str2, int ic, int dc, int rc) {
        //todo  特殊情况的排除

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int len1 = chars1.length;
        int len2 = chars2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i * dc;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i * dc;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1] + ic, dp[i - 1][j] + dc);
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + rc);
                }
            }
        }

        return dp[len1][len2];
    }
}
