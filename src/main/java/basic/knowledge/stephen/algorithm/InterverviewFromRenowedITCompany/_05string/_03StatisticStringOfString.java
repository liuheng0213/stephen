package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;


//字符串的统计字符串
public class _03StatisticStringOfString {
    public static void main(String[] args) {
        _03StatisticStringOfString statisticStringOfString = new _03StatisticStringOfString();
        String str = "aaabbadddffcccc";
        String res = statisticStringOfString.getCountString(str);
        System.out.println(res);
        String origin = statisticStringOfString.getOri(res, 3);
        System.out.println(origin);
    }

    private String getCountString(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        char[] chars = str.toCharArray();
        int num = 1;
        String res = chars[0] + "_";
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                res += concat(String.valueOf(chars[i]), String.valueOf(num));
                num = 1;
            } else {
                num++;
            }
        }
        res += concat("", String.valueOf(num));
        return res;
    }

    private String getOri(String str, int index) {
        if (str == null || str.equals("")) {
            return "";
        }
        boolean numStage = true;
        char[] chars = str.toCharArray();
        int sum = 0;
        int num = 0;
        char cur = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') {  //这个条件一定要放第一个if中
                numStage = !numStage;
            } else if (numStage) {
                sum += num;
                if (sum > index) {
                    return String.valueOf(cur);
                }
                num = 0;
                cur = chars[i];
            } else {
                num = num * 10 + (chars[i] - '0');
            }
        }
        return null;
    }

    private String concat(String s, String num) {
        return num + (s.equals("") ? s : "_" + s + "_");
    }
}
