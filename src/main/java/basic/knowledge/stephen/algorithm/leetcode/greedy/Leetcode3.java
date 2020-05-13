package basic.knowledge.stephen.algorithm.leetcode.greedy;

public class Leetcode3 {
    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        int len = leetcode3.lengthOfLongestSubstring("tmmtzuxt");
        System.out.println(len);
    }

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        if (s.equals("")) {
            return 0;
        }
        int len = 1;
        int left = 0;
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] < left) {
                len = Math.max(len, i - left + 1);
            } else {
                left = map[s.charAt(i)] + 1;
            }
            map[s.charAt(i)] = i;
        }
        return len;
    }
}
