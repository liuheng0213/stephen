package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;


//回文最小分割数
public class _21CutNumForPalidrome {
    public static void main(String[] args) {
        _21CutNumForPalidrome cutNumForPalidrome = new _21CutNumForPalidrome();
        String str = "ACDCDCDADEFDDRR";
        int res = cutNumForPalidrome.getMinCutNum(str);
        System.out.println(res);
    }

    private int getMinCutNum(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();

        //dp[i 含义子串str[i..len - 1]至少需要切割几次
        //这里dp一定要len + 1的长度  因为 dp[i] = Math.min(dp[i], dp[j + 1] + 1); 有len的索引取值
        int[] dp = new int[chars.length + 1];
        dp[chars.length] = -1;

        //markPal[i][j] = true 意味着str[i..j]为回文
        boolean[][] markPal = new boolean[chars.length][chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j] && (j - i < 2 || markPal[i + 1][j - 1])) {
                    markPal[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

}
