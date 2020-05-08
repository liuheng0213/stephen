package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 * 题目描述：leetcode 455

 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

 注意：

 你可以假设胃口值为正。
 一个小朋友最多只能拥有一块饼干。

 示例 1:

 输入: [1,2,3], [1,1]

 输出: 1

 解释:
 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 所以你应该输出1。

 示例 2:

 输入: [1,2], [1,2,3]

 输出: 2

 解释:
 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 所以你应该输出2.

 */
public class CandyAllocation {
    public static void main(String[] args) {
        int[] g = {5,10,2,9,15,9};//小孩的糖果需求因子数组  child
        int[] s = {6,1,20,3,8};//糖果大小数组   candy

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int candy = 0;

        while(child != g.length && candy != s.length){
            if(g[child] <= s[candy]){
                child++;
            }
            candy++;
        }
        // child == g.length || candy == length  出来时的情况
        System.out.println(candy);
    }

    public int findContentChildren(int[] g, int[] s) {
        // 首先对两个数组排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 两个数组的下标索引
        int gi = g.length - 1;
        int si = s.length - 1;
        // 满足孩子的数量
        int result = 0;
        // 分发饼干
        while (gi >= 0 && si >= 0) {
            // 将最大的饼干分给胃口最大的小孩 孩子满足
            if (g[gi] <= s[si]) {
                // 满足孩子数量+1
                result++;
                // 孩子胃口数下标-1
                gi--;
                // 饼干数组下标-1
                si--;
            } else {
                // 将最大的饼干分给胃口最大的小孩 孩子不满足
                // 将饼干分给胃口小一号的孩子
                gi--;
            }
        }
        return result;
    }

}
