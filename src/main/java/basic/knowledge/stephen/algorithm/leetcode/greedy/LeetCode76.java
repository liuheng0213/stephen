package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.HashMap;

public class LeetCode76 {
    public static void main(String[] args) {
        LeetCode76 leetCode76 = new LeetCode76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = leetCode76.minWindow(s, t);
        System.out.println(res);
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int count = t.length();
        int leftIndex = 0;
        int rightIndex = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    count--;
                }
            }

            while (count == 0) {//此时包揽了 所有的t
                if (right - left < min) {
                    min = right - left;
                    leftIndex = left;
                    rightIndex = right;
                }
                //尝试是否能缩短
                char c = s.charAt(left);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) {
                        count++;
                    }
                }
                left++;
            }
            right++;
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(leftIndex, rightIndex + 1);
    }
}
