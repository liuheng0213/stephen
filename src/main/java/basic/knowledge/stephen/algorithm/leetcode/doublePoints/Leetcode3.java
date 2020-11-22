package basic.knowledge.stephen.algorithm.leetcode.doublePoints;

import java.util.HashSet;
import java.util.Set;

/**
 * 快慢双指针  滑动窗口
 */
public class Leetcode3 {
    public static void main(String[] args) {
        Leetcode3 longestNonRepulicate = new Leetcode3();
        String str = "aabccdefg";
        int res = longestNonRepulicate.lengthOfLongestSubstring(str);
        System.out.println(res);
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int end = 0, start = 0;
        Set<Character> set = new HashSet<>();
        while (start < n && end < n) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - start);
            }
        }
        return res;
    }

}
