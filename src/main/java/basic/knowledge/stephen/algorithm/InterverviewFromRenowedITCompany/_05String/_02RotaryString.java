package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05String;
//两个字符串是否互为旋转字符串
public class _02RotaryString {
    public static void main(String[] args) {
        _02RotaryString rotaryWord = new _02RotaryString();
        boolean res = rotaryWord.isRotory("1ab2","ab12");
        System.out.println(res);
    }

    private boolean isRotory(String a, String b) {
        if(a == null || b == null || a.length() != b.length()){
            return false;
        }
        String b2 = b + b;
        return b2.indexOf(a) != -1;
    }
}
