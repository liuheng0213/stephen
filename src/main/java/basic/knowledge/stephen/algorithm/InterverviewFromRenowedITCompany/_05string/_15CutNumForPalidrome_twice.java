package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;


//回文最小分割数  与第一次不同得dp定义
public class _15CutNumForPalidrome_twice {
    public static void main(String[] args) {
        _15CutNumForPalidrome_twice cutNumForPalidrome = new _15CutNumForPalidrome_twice();
        String str = "ACDCDCDADEFDDRR";
        int res = cutNumForPalidrome.minCutNum(str);
        System.out.println(res);
    }

    public int minCutNum(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        //dp[i] 表示 0 ~i得最小切割数量,  //markPal[j][i] = true 意味着str[j..i]为回文
        boolean[][] markPal = new boolean[chars.length][chars.length];
        int[] dp = new int[chars.length];

        // 返回 dp[len - 1]即可
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (chars[j] == chars[i] && (i - j <= 1 || markPal[j + 1][i - 1])) {
                    markPal[j][i] = true;
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }

        }

        return dp[dp.length - 1];
    }
}
