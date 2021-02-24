package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._05string;


//翻转字符串
//双指针的应用
public class _07RotateString {
    public static void main(String[] args) {
        _07RotateString rotateString = new _07RotateString();
        String str = "dog loves pig";
        char[] chars = str.toCharArray();
        rotateString.rotateWord(chars);
        System.out.println(new String(chars));
        String str1 = "ABCDE";
        char[] chars1 = str1.toCharArray();
        rotateString.rotate(chars1, 3);
        System.out.println(new String(chars1));
    }

    private void rotate(char[] chars, int size) {
        if (chars == null || size < 1 || size > chars.length) {
            return;
        }
        reverse(chars, 0, size - 1);
        reverse(chars, size, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
    }

    private void rotateWord(char[] chars) {
        if (chars == null) {
            return;
        }

        reverse(chars, 0, chars.length - 1);

        int left = -1;
        int right = -1;
        for (int i = 0; i < chars.length; i++) {
            left = (i == 0 || chars[i - 1] == ' ') ? i : left;
            right = (i == chars.length - 1 || chars[i + 1] == ' ') ? i : right;

            if (left != -1 && right != -1) {
                reverse(chars, left, right);
                left = -1;
                right = -1;
            }
        }
    }

    private void reverse(char[] chars, int start, int end) {
        char temp = 0;
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            end--;
            start++;
        }
    }
}
