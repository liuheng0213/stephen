package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

//判断字符串中所有字符只出现了一次
public class _04OnceOccur {
    public static void main(String[] args) {
        _04OnceOccur onceOccur = new _04OnceOccur();
        String str = "abca";
        boolean res = onceOccur.isUnique(str);
        System.out.println(res);
    }

    private boolean isUnique(String str) {
        char[] chars = str.toCharArray();
        if (str == null || "".equals(str)) {
            return false;
        }
        boolean[] map = new boolean[256];
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]]) {
                return false;
            }
            map[chars[i]] = true;
        }
        return true;
    }
}
