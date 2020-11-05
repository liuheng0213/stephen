package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

//两个字符串是否互为旋转字符串
public class _02RotaryString {
    public static void main(String[] args) {
        _02RotaryString rotaryWord = new _02RotaryString();
        boolean res = rotaryWord.isRotory("1ab2", "ab21");
        System.out.println(res);
    }

    private boolean isRotory(String a, String b) {
        if(a==null || b == null){
            return false;
        }
        String tempStr = b + b;
       return tempStr.indexOf(a) != -1;
    }
}
