package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05String;

public class _02RotaryWord {
    public static void main(String[] args) {
        _02RotaryWord rotaryWord = new _02RotaryWord();
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
