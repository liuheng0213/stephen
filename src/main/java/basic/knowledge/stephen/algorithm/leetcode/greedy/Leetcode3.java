package basic.knowledge.stephen.algorithm.leetcode.greedy;

public class Leetcode3 {
    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        int len = leetcode3.lengthOfLongestSubstring("tmmtzuxt");
        System.out.println(len);
    }

    /**
     * left 是 i之前的 left 之间的(且是无重复子串)的起始点
     *  如果元素  在此之间(含left 含i ) 有重复, 则更新left
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        if (s.equals("")) {
            return 0;
        }
        int len = 0;
        int left = 0;
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] < left) {
                len = Math.max(len, i - left + 1);
            } else {// map[s.charAt(i)]  不可能等于i 不需要<= i的判断
                left = map[s.charAt(i)] + 1;//旧 索引
            }
            map[s.charAt(i)] = i;//新 索引

        }
        return len;
    }
}
