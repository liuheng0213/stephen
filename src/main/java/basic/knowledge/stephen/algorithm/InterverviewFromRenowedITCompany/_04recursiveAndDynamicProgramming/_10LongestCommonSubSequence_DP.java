package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

import org.apache.commons.lang3.StringUtils;

public class _10LongestCommonSubSequence_DP {
    public static void main(String[] args) {
        _10LongestCommonSubSequence_DP longestCommonSubSequence = new _10LongestCommonSubSequence_DP();
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        String res = longestCommonSubSequence.lcst(str1, str2);
        System.out.println(res);
    }

    private String lcst(String str1, String str2) {
        if (StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2)) {
            return "";
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = getDp(chars1, chars2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (dp[i][j] > max) {
                    end = j;
                    max = dp[i][j];
                }
            }
        }

        return str2.substring(end - max + 1, end + 1);
    }

    /**
     * 合理的构造dp,指定dp的含义:
     * 本体dp[i][j] 表示的是chars1[0..i] 且公共子串的最后字母为chars1[i];
     * chars2[0..j] 且公共子串的最后字母为chars2[j]
     * 的最大子串
     *
     *  最大值并不一定
     *  是dp[m -1][n - 1];
     * @param chars1
     * @param chars2
     * @return
     */
    private int[][] getDp(char[] chars1, char[] chars2) {
        int m = chars1.length;
        int n = chars2.length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (chars1[i] == chars2[0]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }

        for (int j = 0; j < n; j++) {
            if (chars2[j] == chars1[0]) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }
}
