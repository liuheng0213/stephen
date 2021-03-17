package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

import java.util.HashSet;

//找到字符串的最长无重复字符子串
public class _19LongestNonRepulicate {
    public static void main(String[] args) {
        _19LongestNonRepulicate longestNonRepulicate = new _19LongestNonRepulicate();
        String str = "aabccdefg";
        int res = longestNonRepulicate.longestNonRepulicate(str);
        int res2 = longestNonRepulicate.longestNonRepulicate_easyMethod(str);
        System.out.println(res);
        System.out.println(res2);
    }

    private int longestNonRepulicate_easyMethod(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                num = 0;
            } else {

            }
        }
        return max;
    }

    private int longestNonRepulicate(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int[] map = new int[256];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map[chars[i]] = -1;
        }
        int left = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] >= left) {
                left = map[chars[i]] + 1;
            } else {
                max = Math.max(max, i - left + 1);
            }
            map[chars[i]] = i;
        }
        return max;
    }
}
