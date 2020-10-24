package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;


//字符串的交错组成
public class _13CrossCombine_DP {
    public static void main(String[] args) {
        _13CrossCombine_DP crossCombine = new _13CrossCombine_DP();
        String str1 = "ABC";
        String str2 = "123";
        String aim = "B1AC23";
        boolean res = crossCombine.isCross(str1, str2, aim);
        System.out.println(res);
    }

    /**
     * dp[i][j] 表示 aim[0..i + j -1]能否被str1[0..i- 1]交错组合str2[0..j-1]而成
     * <p>
     * <p>
     * i == 0 时意味着  ""
     * <p>
     * <p>
     * 如果
     * <p>
     * dp[i][j] 表示 aim[0..i + j + 1]能否被str1[0..i]交错组合str2[0..j]而成
     * <p>
     * 无法用i == 0 or j == 0表示空串""
     *
     * @param str1
     * @param str2
     * @param aim
     * @return
     */
    private boolean isCross(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null) {
            return false;
        }


        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] charsAim = aim.toCharArray();

        int length1 = chars1.length;
        int length2 = chars2.length;
        int lenAim = charsAim.length;

        if (lenAim != length1 + length2) {
            return false;
        }
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = aim.equals("") ? true : false;
        for (int i = 1; i < dp.length; i++) {
            if (chars1[i - 1] != charsAim[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j < dp[0].length; j++) {
            if (chars2[j - 1] != charsAim[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i - 1][j] && chars1[i - 1] == charsAim[i + j - 1]
                        || dp[i][j - 1] && chars2[j - 1] == charsAim[i + j - 1]) {
                }
                dp[i][j] = true;
            }
        }
        return dp[length1][length2];

    }
}
