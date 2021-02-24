package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._05string;


/**
 * 括号字符串的有效性和最长有效长度
 */
public class _14MaxEffectiveLengthInBracketString {
    public static void main(String[] args) {
        _14MaxEffectiveLengthInBracketString maxEffectiveLengthInBracketString = new _14MaxEffectiveLengthInBracketString();
        String str = "()(()())(";
        boolean isValid = maxEffectiveLengthInBracketString.osValid(str);
        System.out.println(isValid);

        //进阶问题

        int res = maxEffectiveLengthInBracketString.getMaxLen(str);
        System.out.println(res);

    }

    private int getMaxLen(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int max = 0;
        int[] dp = new int[chars.length];
        int pre = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2;
                    dp[i] += pre - 1 >= 0 ? dp[pre - 1] : 0;
                }
                max = Math.max(dp[i], max);

            }
        }
        return max;
    }

    private boolean osValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        int status = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                status++;
            }

            if (chars[i] == ')' && status-- == 0) {
                return false;
            }

            if (chars[i] != ')' && chars[i] != '(') {
                return false;
            }
        }

        return status == 0;
    }


}
