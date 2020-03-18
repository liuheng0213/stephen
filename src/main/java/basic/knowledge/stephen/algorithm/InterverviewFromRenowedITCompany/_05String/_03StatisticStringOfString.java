package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05String;


//字符串的统计字符串
public class _03StatisticStringOfString {
    public static void main(String[] args) {
        _03StatisticStringOfString statisticStringOfString = new _03StatisticStringOfString();
        String str = "aaabbadddffc";
        String res = statisticStringOfString.getCountString(str);
        System.out.println(res);
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
            }else{
                num++;
            }
        }

        return concat(res,String.valueOf(num),"");
    }

    private String concat(String s1, String s2, String s3) {
        return s1 + "_" + s2 + (s3.equals("")? s3 : "_" + s3);  //这个三元运算符是保证结尾也要有个数字
    }
}
