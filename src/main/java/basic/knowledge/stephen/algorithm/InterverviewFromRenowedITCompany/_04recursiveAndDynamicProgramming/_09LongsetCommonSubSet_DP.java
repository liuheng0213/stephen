package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

import org.apache.commons.lang3.StringUtils;

//求两个字符串共同的序列
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

        int resLen = dp[m][n];
        char[] res = new char[resLen];
        int index = resLen - 1;
        while (m > 0 || n > 0) { //或者index >= 0
            if (chars1[m] == chars2[n]) {
                res[index--] = chars1[m];
                m--;
                n--;
            } else {
                if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                    m--;
                } else if (n > 0) {
                    n--;
                }
            }
        }

        //出来时 必有 m== 0 && n == 0

        return new String(res);

    }

    /**
     * dp 含义:
     * dp[i][j] 表示 0..i; 0..j 相同的序列的长度
     *
     * @param chars1
     * @param chars2
     * @return
     */
    private int[][] getDp(char[] chars1, char[] chars2) {
        int[][] dp = new int[chars1.length][chars2.length];
        int mark = -1;
        for (int i = 1; i < chars1.length; i++) {
            dp[i][0] = Math.max(chars1[i] == chars2[i] ? 1 : 0, dp[i - 1][0]);
        }

        mark = -1;
        for (int i = 0; i < chars2.length; i++) {
            if (chars1[0] == chars2[i]) {
                mark = i;
                dp[0][i] = 1;
            } else if (i >= mark) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp;

    }
}
