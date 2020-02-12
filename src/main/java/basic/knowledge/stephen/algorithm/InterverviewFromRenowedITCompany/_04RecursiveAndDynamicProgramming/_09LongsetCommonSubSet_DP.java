package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

import org.apache.commons.lang3.StringUtils;

public class _09LongsetCommonSubSet_DP {
    public static void main(String[] args) {
        _09LongsetCommonSubSet_DP longsetCommonSubSet = new _09LongsetCommonSubSet_DP();
        String str1 = "1A2C3D4B56７";
        String str2 = "B1D23CA45B6A";
        String res = longsetCommonSubSet.getLcs(str1, str2);
        System.out.println(res);
    }


    private String getLcs(String str1, String str2) {
        if (StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2)) {
            return "";
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = getDp(chars1, chars2);
        int m = chars1.length - 1;
        int n = chars2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = chars1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);

    }

    /**
     * dp 含义:
     * @param chars1
     * @param chars2
     * @return
     */
    private int[][] getDp(char[] chars1, char[] chars2) {
        int m = chars1.length;
        int n = chars2.length;
        int[][] dp = new int[m][n];
        dp[0][0] = chars1[0] == chars2[0] ? 1 : 0;
        for (int i = 1; i < m; i++) {
            if (chars1[i] == chars2[0]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }


        for (int i = 1; i < n; i++) {
            if (chars1[0] == chars2[i]) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

                // 与上面的逻辑一样滴?　　
//                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                if (chars1[i] == chars2[j]) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
//                }

            }
        }

        return dp;
    }
}
