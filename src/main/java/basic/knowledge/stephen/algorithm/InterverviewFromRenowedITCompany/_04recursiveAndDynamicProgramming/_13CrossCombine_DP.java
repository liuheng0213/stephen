package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

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
        char[] aimChars = aim.toCharArray();

        if (chars1.length + chars2.length != aimChars.length) {
            return false;
        }
        int row = chars1.length;
        int col = chars2.length;
        boolean[][] dp = new boolean[row + 1][col + 1];
        dp[0][0] = true;
        for (int i = 1; i <= row; i++) {
            if (aimChars[i - 1] != chars1[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }

        for (int j = 1; j <= col; j++) {
            if (aimChars[j - 1] != chars2[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (dp[i - 1][j] && aimChars[i + j - 1] == chars1[i - 1]) {
                    dp[i][j] = true;
                }

                if (dp[i][j - 1] && aimChars[i + j - 1] == chars2[j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[row][col];
    }
}
