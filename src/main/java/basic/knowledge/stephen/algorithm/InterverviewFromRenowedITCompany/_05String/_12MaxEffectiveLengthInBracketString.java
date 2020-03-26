package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05String;


/**
 * 括号字符串的有效性和最长有效长度
 */
public class _12MaxEffectiveLengthInBracketString {
    public static void main(String[] args) {
        _12MaxEffectiveLengthInBracketString maxEffectiveLengthInBracketString = new _12MaxEffectiveLengthInBracketString();
        String str = "()(()()(";
       /* boolean isValid = maxEffectiveLengthInBracketString.osValid(str);
        System.out.println(isValid);*/

        //进阶问题
        int res = maxEffectiveLengthInBracketString.getMaxLen(str);
        System.out.println(res);

    }

    private int getMaxLen(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();
        //dp[i] 含义: 必须以str[i] 结尾 的最长有效括号子串长度----该子串必须包含str[i]这个字符
        int[] dp = new int[chars.length];

        //dp[i] 默认为0
        int pre = 0;//有效长度的第一个字符所在的索引
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private boolean osValid(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        int left = 0;
        int right = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left++;
            } else if (chars[i] == ')') {
                right++;
            } else {
                return false;
            }
            if (right > left) {
                return false;
            }
        }

        if (left != right) {
            return false;
        }

        return true;
    }
}
