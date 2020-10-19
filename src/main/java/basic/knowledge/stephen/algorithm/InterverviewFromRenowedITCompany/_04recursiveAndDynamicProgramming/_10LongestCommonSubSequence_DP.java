package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _10LongestCommonSubSequence_DP {
    public static void main(String[] args) {
        _10LongestCommonSubSequence_DP longestCommonSubSequence = new _10LongestCommonSubSequence_DP();
        String str1 = "1AB2345ECD";
        String str2 = "12345EF";
        String res = longestCommonSubSequence.lcst(str1, str2);
        System.out.println(res);
    }

    private String lcst(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return "";
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] res = getDp(chars1, chars2);

        return str1.substring(res[1] - res[0] + 1,res[1] + 1);
    }

    /**
     * 合理的构造dp,指定dp的含义:
     * 本体dp[i][j] 表示的是chars1[0..i] 且公共子串的最后字母为chars1[i];
     * chars2[0..j] 且公共子串的最后字母为chars2[j]
     * 的最大子串的长度
     * <p>
     * 最大值并不一定
     * 是dp[m -1][n - 1];
     *
     * @param chars1
     * @param chars2
     * @return
     */
    private int[] getDp(char[] chars1, char[] chars2) {

        int m = chars1.length;
        int n = chars2.length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = chars1[i] == chars2[0] ? 1 : 0;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = chars1[0] == chars2[i] ? 1 : 0;
        }

        int maxLen = Integer.MIN_VALUE;
        int rowMaxLenIndex = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(chars1[i] == chars2[j]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    rowMaxLenIndex = i;
                }
            }
        }

        int[] res= new int[2];
        res[0] = maxLen;
        res[1] = rowMaxLenIndex;
        return res;
    }
}
