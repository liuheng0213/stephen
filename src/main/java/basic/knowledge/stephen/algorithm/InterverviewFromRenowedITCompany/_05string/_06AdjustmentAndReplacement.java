package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;


//字符串的调整与替换
public class _06AdjustmentAndReplacement {
    public static void main(String[] args) {
        _06AdjustmentAndReplacement adjustmentAndReplacement = new _06AdjustmentAndReplacement();
        char[] chars = new char[]{'a', ' ', 'b', ' ', ' ', 'c', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String res = adjustmentAndReplacement.replace(chars);
        String str = "12**345";
        String strRes = adjustmentAndReplacement.modify(str);
        System.out.println(strRes);
    }

    /**
     * 遇到数字直接复制
     *
     * @param str
     * @return
     */
    private String modify(String str) {
        if(str == null || str.equals("")){
            return "";
        }
        char[] chars = str.toCharArray();
        int j = chars.length - 1;
        for(int i = chars.length - 1;i >=0;i--){
            if(chars[i] != '*'){
                chars[j--] = chars[i];
            }
        }

        for(;j >= 0;j--){
            chars[j] = '*';
        }
        return String.valueOf(chars);
    }

    /**
     * 空格 整成 %20
     *
     * @param chars
     * @return
     */
    private String replace(char[] chars) {
        int blankNum = 0;
        int len = 0;
        for (len = 0; len < chars.length && chars[len] != 0; len++) {
            if (chars[len] == ' ') {
                blankNum++;
            }
        }
        int index = len + 2 * blankNum - 1;

        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                chars[index--] = chars[i];
            } else {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            }
        }

        return String.valueOf(chars);
    }
}
