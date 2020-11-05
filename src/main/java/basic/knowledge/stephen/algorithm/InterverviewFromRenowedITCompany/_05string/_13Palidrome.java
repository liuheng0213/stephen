package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;


//动态规划:
//添加最少字符使字符串整体成为回文
public class _13Palidrome {
    public static void main(String[] args) {
        String str = "ACDEDF";
        _13Palidrome palidrome = new _13Palidrome();
        String res = palidrome.getPalidrome(str);
        System.out.println(res);
    }

    private String getPalidrome(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        int[][] dp = getDp(chars);

        char[] res = new char[chars.length + dp[0][dp[0].length - 1]];

        int i = 0;
        int j = chars.length - 1;
        int left = 0;
        int right = res.length - 1;
        while (i <= j) {
            if (chars[i] == chars[j]) {
                res[left++] = chars[i++];
                res[right--] = chars[j--];
            } else if ((dp[i + 1][j] < dp[i][j - 1])) {
                res[left++] = chars[i];
                res[right--] = chars[i++];
            } else {
                res[left++] = chars[j];
                res[right--] = chars[j--];
            }
        }

        return String.valueOf(res);
    }

    private int[][] getDp(char[] chars) {
        int[][] dp = new int[chars.length][chars.length];
        //int i = dp.length - 1; i >= 1; i--  绝对不可以 否则  dp[i][j]内循环第一个进不去  那么最后dp[0][lenth - 1] == 0
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i +1][i] = chars[i +1] == chars[i] ? 0 : 1;
            for (int j = i + 1; j <= dp[0].length - 1; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp;

    }


}
