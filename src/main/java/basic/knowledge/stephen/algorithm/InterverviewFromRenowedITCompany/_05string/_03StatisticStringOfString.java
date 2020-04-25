package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;


//字符串的统计字符串
public class _03StatisticStringOfString {
    public static void main(String[] args) {
        _03StatisticStringOfString statisticStringOfString = new _03StatisticStringOfString();
        String str = "aaabbadddffc";
        String res = statisticStringOfString.getCountString(str);
        System.out.println(res);
        String origin = statisticStringOfString.getOri(res, 9);
        System.out.println(origin);
    }

    private String getOri(String res, int index) {
        if (res == null || "".equals(res)) {
            return String.valueOf(0);
        }
        int sum = 0;//记录原字符串的进度
        int num = 0;//记录某一个字符的数字
        char cur = 0;
        boolean stage = true;//false:连续阶段; true:遇到新的字符
        char[] chars = res.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') {
                stage = !stage;//阶段转换
            } else if (stage) { //遇到新阶段
                sum += num;
                //一定要大于, 这里是遇到新原字符了, sum描述的上一个字符的总数, 而return的是上一个字符
                if (sum > index) {
                    return String.valueOf(cur);
                }
                num = 0;
                cur = chars[i];
            } else {  // 连续阶段 and not '_'  计算字符的个数
                num = num * 10 + chars[i] - '0';
            }
        }

        return sum + num > index ? String.valueOf(cur) : String.valueOf(0);
    }

    private String getCountString(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        char[] chars = str.toCharArray();
        String res = String.valueOf(chars[0]);
        int num = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                res = concat(res, String.valueOf(num), String.valueOf(chars[i]));
                num = 1;
            } else {
                num++;
            }
        }

        return concat(res, String.valueOf(num), "");//最后的结尾别忘记了
    }

    private String concat(String s1, String s2, String s3) {
        return s1 + "_" + s2 + (s3.equals("") ? s3 : "_" + s3);  //这个三元运算符是保证结尾也要有个数字
    }
}
