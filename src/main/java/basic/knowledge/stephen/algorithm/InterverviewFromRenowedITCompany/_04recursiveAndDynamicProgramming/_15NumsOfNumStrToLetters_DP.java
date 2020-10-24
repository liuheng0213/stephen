package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;


//数字字符串转换为字母组合的总数  DP法
public class _15NumsOfNumStrToLetters_DP {
    public static void main(String[] args) {
        _15NumsOfNumStrToLetters_DP numsOfNumStrToLetters = new _15NumsOfNumStrToLetters_DP();
        String str = "11110312321";
        int res = numsOfNumStrToLetters.num1(str);
        int res1 = numsOfNumStrToLetters.num2(str);
        System.out.println(res);
        System.out.println(res1);
    }

    /**
     * dp[i] 表示str[0..i - 1]转换完毕 str[i.. N-1] 还没转换的情况下， 剩下的没转换的部分转换的种类数
     * dp[0] 表示整体全部转换总数
     *
     * @param str
     * @return
     */
    private int num2(String str) {
        if (str == null) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[dp.length - 1] = 1;
        for (int i = dp.length - 2; i >= 0; i--) {
            if(chars[i] != '0'){
                dp[i] = dp[i + 1];
                if (i + 1 < chars.length && ((chars[i] - '0') * 10 + (chars[i + 1] - '0')) < 27) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    /**
     * 注意与上面dp的区别
     * @param str
     * @return
     */
    private int num1(String str) {
        if (str == null) {
            return 0;
        }
        char[] chars = str.toCharArray();


        int next = 1;
        int cur = chars[chars.length - 1] == '0' ? 0 : 1;
        int temp = 0;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] == '0') { //chars[i] == '0' 一定要有  这个没有dp default value = 0了
                next = cur;
                cur = 0;
            } else {
                if (i + 1 < chars.length && ((chars[i] - '0') * 10 + (chars[i + 1] - '0')) < 27) {
                    temp = cur;
                    cur = cur + next;
                    next = temp;
                } else {
                    //想想下面的为什么错! 在进入这个i 之前 cur 就是指的i + 1的值 所以应该是 cur = cur;
//                    cur = next;
//                    next = cur;

                    temp = cur;
                    next = temp;
                }
            }
        }

        return cur;
    }

}
