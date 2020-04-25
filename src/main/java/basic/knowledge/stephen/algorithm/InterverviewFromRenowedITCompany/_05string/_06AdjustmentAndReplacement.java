package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;


//字符串的调整与替换
public class _06AdjustmentAndReplacement {
    public static void main(String[] args) {
        _06AdjustmentAndReplacement adjustmentAndReplacement = new _06AdjustmentAndReplacement();
        char[] chars = new char[]{'a', ' ', 'b', ' ', ' ', 'c', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //String res = adjustmentAndReplacement.replace(chars);
        String str = "12**345";
        String res = adjustmentAndReplacement.modify(str);
        System.out.println(res);
    }

    /**
     * 遇到数字直接复制
     *
     * @param str
     * @return
     */
    private String modify(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        int j = chars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if(chars[i] != '*'){
                chars[j--] = chars[i];
            }
        }
        //此时J 的右边全不是*
        for(;j >=0;j--){
            chars[j] ='*';
        }
        return new String(chars);
    }

    private String replace(char[] chars) {
        if (chars == null || chars.length == 0) {
            return "";
        }
        //计算空格的数量
        int num = 0;
        int len = 0;

        for (len = 0; len < chars.length && chars[len] != 0; len++) {
            if (chars[len] == ' ') {
                num++;
            }
        }
        int j = len + num * 2 - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                chars[j--] = chars[i];
            } else {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            }
        }
        return new String(chars).substring(0, chars.length - len + 1);
    }
}
