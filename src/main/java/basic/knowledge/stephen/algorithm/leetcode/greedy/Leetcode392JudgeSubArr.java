package basic.knowledge.stephen.algorithm.leetcode.greedy;

//Leetcode_392. 判断子序列

/**
 * 题目描述：
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = “abc”, t = “ahbgdc”
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = “axc”, t = “ahbgdc”
 * <p>
 * 返回 false.
 * <p>
 * 后续挑战 :
 * <p>
 * 如果有大量输入的 S，称作S1, S2, … , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */
public class Leetcode392JudgeSubArr {
    public static void main(String[] args) {
        Leetcode392JudgeSubArr judgeSubArr = new Leetcode392JudgeSubArr();
        String s = "acb";
        String t = "ahbjjcde";
        boolean isSe = judgeSubArr.isSubsequence(s, t);
        System.out.println(isSe);

    }

    private boolean isSubsequence2(String s, String t) {
        if ("".equals(s)) {
            return true;
        }

        int i = 0;
        int j = 0;
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        while (i != chars_s.length && j != chars_t.length) {
            if (chars_s[i] == chars_t[j]) {
                i++;
            }
            j++;
        }
        return i == chars_s.length;
    }

    public boolean isSubsequence(String s, String t) {
        // 起始索引
        int index = -1;
        for (char c : s.toCharArray()) {
            // 查询字符在不在字符串t中
            index = t.indexOf(c, index + 1);
            // 查询不到
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
