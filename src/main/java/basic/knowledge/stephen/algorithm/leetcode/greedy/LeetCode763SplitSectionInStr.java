package basic.knowledge.stephen.algorithm.leetcode.greedy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目描述：对于给定的字符串（组成为小写字母），划分为n个子串，要求每个字母最多只出现在一个子串中。输出子串的长度。
 * <p>
 * 例子：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * <p>
 * 输出：[9,7,8]
 * <p>
 * 描述：划分子串为 "ababcbaca", "defegde", "hijhklij"
 */
public class LeetCode763SplitSectionInStr {
    public static void main(String[] args) {
        LeetCode763SplitSectionInStr leetCode763SplitSectionInStr = new LeetCode763SplitSectionInStr();
        String str = "ababcebacadefegdehijhklij";
        List<Integer> res = leetCode763SplitSectionInStr.violenceSearch(str);
        List<Integer> res1 = leetCode763SplitSectionInStr.overlappedSpace(str);
        System.out.println(res);
        System.out.println(res1);
    }

    /**
     * 用重叠区间的方法
     * @param str
     * @return
     */
    private List<Integer> overlappedSpace(String str) {
        List<Integer> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        if(str == null || str.length() == 0){
            return res;
        }
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            map.put(chars[i],i);
        }

        int start = 0;
        int end = 0;
        for(int i = 0;i < len; i++){
            end = Math.max(end, map.get(chars[i]));
            if(i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }

    private List<Integer> violenceSearch(String str) {
        List<Integer> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        int start = 0;
        int end = 0;
        int len = chars.length;
        int cur = chars[0];
        for (int i = 0; i < len; i++) {
            cur = chars[i];
            //从当前位置的下一位置开始查找当前字符所出现的最远位置
            //end 是  一段里的最后  索引
            for (int j = i + 1; j < len; j++) {
                if (cur == chars[j]) {
                    end = Math.max(end, j);
                }
            }

            //如果已经到达可划分的位置
            if (i == end) {
                res.add(end - start + 1);
                //如果不是最后一个元素则 start 和 end 同时初始化为当前结尾的下一个位置
                if (i != len - 1) {
                    start = ++end;
                }
            }
        }

        return res;
    }
}
