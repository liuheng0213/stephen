package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05String;


//动态规划:
//添加最少字符使字符串整体成为回文
public class _11Palidrome {
    public static void main(String[] args) {
        String str = "ACDEDF";
        _11Palidrome palidrome = new _11Palidrome();
        String res = palidrome.getPalidrome(str);
        System.out.println(res);
    }

    private String getPalidrome(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }

        char[] chars = str.toCharArray();
        int[][] dp = getDP(chars);

        char[] res = new char[str.length() + dp[0][str.length() - 1]];
        int i = 0;
        int j = chars.length - 1;

        int resL = 0;
        int resR = res.length - 1;

        //双指针
        while (i <= j) {
            if (chars[i] == chars[j]) {
                res[resL++] = chars[i++];
                res[resR--] = chars[j--];
            } else if (dp[i + 1][j] < dp[i][j - 1]) {
                res[resL++] = chars[i];
                res[resR--] = chars[i++];
            } else {
                res[resL++] = chars[j];
                res[resR--] = chars[j--];
            }
        }
        return String.valueOf(res);
    }

    /**
     * dp[i][j] 意味着 str[i...j] 改装成回文时所添加的最小字符的数量
     *
     * @param chars
     * @return
     */
    private int[][] getDP(char[] chars) {
        int len = chars.length;
        int[][] dp = new int[len][len];

        //dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j - 1] + 1);
        //可知  i依赖于更大的i ; j依赖于更小的j
        //so   i必须递减  ; j 必须递增
        for (int i = len - 2; i > -1; i--) {
            dp[i + 1][i] = chars[i + 1] == chars[i] ? 0 : 1;
            for (int j = i + 2; j < len; j++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j - 1] + 1);
                } else {
                    dp[i][j] = dp[i + 1][j - 1];//可知  i依赖于更大的i ; j依赖于更小的j
                }
            }
        }
        return dp;
    }

}
