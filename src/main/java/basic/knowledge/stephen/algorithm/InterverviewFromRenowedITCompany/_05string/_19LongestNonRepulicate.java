package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

import java.util.HashSet;

//找到字符串的最长无重复字符子串
public class _19LongestNonRepulicate {
    public static void main(String[] args) {
        _19LongestNonRepulicate longestNonRepulicate = new _19LongestNonRepulicate();
        String str = "ABCBCDEFG";
        int res = longestNonRepulicate.longestNonRepulicate(str);
        System.out.println(res);
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
        int left = 0;
        int maxLen = 1;
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] >= left) {
                left = map[chars[i]] + 1;
            } else {
                maxLen = Math.max(maxLen, i - left + 1);
            }
            map[chars[i]] = i;
        }
        return maxLen;
    }
}
