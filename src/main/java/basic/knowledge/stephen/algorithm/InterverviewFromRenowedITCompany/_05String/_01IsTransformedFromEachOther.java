package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05String;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 判断两字符串 是否为变形词
 */
public class _01IsTransformedFromEachOther {
    public static void main(String[] args) {
        String str1 = "1234432678";
        String str2 = "2312344769";

        _01IsTransformedFromEachOther isTransformedFromEachOther = new _01IsTransformedFromEachOther();
        boolean res1 = isTransformedFromEachOther.isTransformed(str1, str2);
        boolean res2 = isTransformedFromEachOther.isBetterTransformed(str1, str2);
        System.out.println(res1 == res2);
    }

    /**
     * String str1 = "1234432";
     * String str2 = "231234";
     * 这个情况就不对  最后还是需要一波遍历map
     *
     * @param str1
     * @param str2
     * @return
     */
    private boolean isBetterTransformed(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        char[] chars1 = str1.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chars1.length; i++) {
            map[chars1[i]]++;
        }
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            if (map[chars2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isTransformed(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        char[] chars1 = str1.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars1) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        char[] chars2 = str2.toCharArray();
        for (char ch : chars2) {
            if (map.containsKey(ch)) {
                if(map.get(ch) == 0){
                    return false;
                }
                map.put(ch, map.get(ch) - 1);

            } else {
                map.put(ch, -1);
                return false;
            }
        }
        return true;
    }
}
