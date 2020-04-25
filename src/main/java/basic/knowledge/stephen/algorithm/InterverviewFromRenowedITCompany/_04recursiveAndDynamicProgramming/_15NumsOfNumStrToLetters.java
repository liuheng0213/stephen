package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _15NumsOfNumStrToLetters {
    public static void main(String[] args) {
        _15NumsOfNumStrToLetters numsOfNumStrToLetters = new _15NumsOfNumStrToLetters();
        String str = "11110312";
        int res = numsOfNumStrToLetters.num1(str);
        System.out.println(res);
    }

    private int num1(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        return process(chars, 0);
    }

    /**
     * 计算返回从str[0..n-1]转换总数
     * @param chars
     * @param i
     * @return
     */
    private int process(char[] chars, int i) {
        if (i == chars.length) {
            return 1;
        }
        if (chars[i] == '0') {
            return 0;
        }

        int res = process(chars, i + 1);
        if (i + 1 < chars.length && ((chars[i] - '0') * 10 + (chars[i + 1] - '0') < 27)) {
            res += process(chars, i + 2);
        }

        return res;
    }
}
