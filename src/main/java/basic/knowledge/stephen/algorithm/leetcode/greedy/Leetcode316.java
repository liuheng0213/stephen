package basic.knowledge.stephen.algorithm.leetcode.greedy;

public class Leetcode316 {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        // map value == - 1 意味着 "删除"
        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a']++;
        }

        int index = 0;
        int left = 0;
        int right = 0;
        char[] res = new char[26];
        while (right < chars.length) {
            if (map[chars[right] - 'a'] == -1 || --map[chars[right] - 'a'] > 0) { //想想为什么不是等于>= 0  babac 就不行
                right++;
            } else {

                int minLex = -1;
                for (int i = left; i <= right; i++) {
                    if (map[chars[i] - 'a'] != -1 && (minLex == -1 || chars[i] < chars[minLex])) {
                        minLex = i;
                    }
                }
                res[index++] = chars[minLex];
                map[chars[minLex] - 'a'] = -1;
                for (int i = minLex + 1; i <= right; i++) {
                    if (map[chars[i] - 'a'] != -1) {
                        map[chars[i] - 'a']++;
                    }
                }
                left = minLex + 1;
                right = left;
            }

        }
        return new String(res, 0, index);
    }
}
