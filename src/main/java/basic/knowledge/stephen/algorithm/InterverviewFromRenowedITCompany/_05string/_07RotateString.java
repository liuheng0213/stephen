package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;




//翻转字符串
//双指针的应用
public class _07RotateString {
    public static void main(String[] args) {
        _07RotateString rotateString = new _07RotateString();
        /* String str = "dog loves pig";
        char[] chars = str.toCharArray();
        rotateString.rotateWord(chars);
        System.out.println(new String(chars));*/
        String str1 = "ABCDE";
        char[] chars1 = str1.toCharArray();
        rotateString.rotate(chars1,3);
        System.out.println(new String(chars1));
    }

    private void rotate(char[] chars, int size) {
        if(chars == null || chars.length == 0 || size > chars.length){
            return;
        }
        reverse(chars, 0,chars.length - 1);
        reverse(chars,0 ,chars.length - size - 1);
        reverse(chars,chars.length - size ,chars.length -1);
    }

    private void rotateWord(char[] chars) {
        if (chars == null && chars.length == 0) {
            return;
        }
        reverse(chars, 0, chars.length - 1);

        //l ,r 定位每一个单词的长度
        int l = -1;
        int r = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                //只要i的左边是空格 , l = i, i = 0 最左不算
                l = (i == 0 || chars[i - 1] == ' ') ? i : l;
                //只要r的右边是空格 , r = i, i = chars.length - 1 最左不算
                r = (i == chars.length - 1 || chars[i + 1] == ' ') ? i : r;
            }

            if (l != -1 && r != -1) {  //一定要判断, 上面的if 也可能进不去
                reverse(chars, l, r);
                //重新复原 别忘了
                l = -1;
                r = -1;
            }
        }
    }

    private void reverse(char[] chars, int start, int end) {
        char temp = 0;
        while (start <= end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
