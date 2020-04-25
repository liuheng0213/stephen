package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

import java.util.HashMap;
import java.util.Map;

//找到字符串的最长无重复字符子串
public class _14LongestNonRepulicate {
    public static void main(String[] args) {
        _14LongestNonRepulicate longestNonRepulicate = new _14LongestNonRepulicate();
        String str = "aabccdefg";
        int res = longestNonRepulicate.longestNonRepulicate(str);
        System.out.println(res);
    }

    private int longestNonRepulicate(String str) {
        int pre = -1;
        int res = 0;
        char[] chars = str.toCharArray();
        Map<Character, Integer> preMap = new HashMap<>();
        preMap.put(chars[0], 0);
        int lastOcuIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            lastOcuIndex = preMap.containsKey(chars[i]) ? preMap.get(chars[i]) : -1;
            if (lastOcuIndex < pre) {
                res = Math.max(res, i - (pre + 1) + 1);
            } else {
                res = Math.max(res, i - (lastOcuIndex + 1) + 1);
                pre = lastOcuIndex;
            }

            preMap.put(chars[i], i);
        }
        return res;
    }
}
