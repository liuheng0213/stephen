package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _15NumsOfNumStrToLetters_DP {
    public static void main(String[] args) {
        _15NumsOfNumStrToLetters_DP numsOfNumStrToLetters = new _15NumsOfNumStrToLetters_DP();
        String str = "11110312";
        int res = numsOfNumStrToLetters.num1(str);
        System.out.println(res);
    }

    /**
     * p[i] 表示str[0..i - 1]转换完毕 str[i.. N-1] 还没转换的情况下， 剩下的没转换的部分转换的种类数
     * p[0] 表示整体全部转换总数
     * @param str
     * @return
     */
    private int num1(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int n = str.length();
        int[] p = new int[n + 1];
        p[n] = chars[n - 1] == '0' ? 0 : 1;
        p[n - 1] = p[n];

        for (int i = 1; i <= n - 2; i++) {
            if (chars[i] - '0' == 0) {
                p[i] = 0;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (chars[i] != '0') {
                p[i] = p[i + 1];
                if ((chars[i] - '0') * 10 + (chars[i + 1] - '0') < 27) {
                    p[i] += p[i + 2];
                }
            }else{
                p[i] = 0;
            }
        }
        return p[0];
    }

}
