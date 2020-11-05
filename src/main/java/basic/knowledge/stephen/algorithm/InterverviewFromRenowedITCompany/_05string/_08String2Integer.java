package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

//将整数字符转换成整数值
public class _08String2Integer {
    public int convert(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        if (!isValid(chars)) {
            return 0;
        }
        int minQ = Integer.MIN_VALUE / 10;
        int minR = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        boolean positive = chars[0] == '-' ? false : true;
        for (int i = positive ? 0 : 1; i < chars.length; i++) {
            cur = '0' - chars[i];
            if (res < minQ || (res == minQ && cur < minR)) {
                return 0;
            }
            res = res * 10 + cur;
        }
        if (positive && res == Integer.MIN_VALUE) {
            return 0;
        }
        return positive ? -res : res;
    }

    private boolean isValid(char[] chars) {
        if (chars[0] != '-' && (chars[1] < '0' || chars[1] > '9')) {
            return false;
        }

        if (chars[0] == '-' && (chars.length == 1 || chars[1] == '0')) {
            return false;
        }
        if (chars[0] == '0' && chars.length > 1) {
            return false;
        }

        for (int i = 1; i < chars.length; i++) {
            if (chars[1] < '0' || chars[1] > '9') {
                return false;
            }
        }

        return true;
    }
}
