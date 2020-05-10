package basic.knowledge.stephen.algorithm.leetcode.greedy;
// 最后一块石头的重量
// leetcode 1046

import java.util.Arrays;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x < y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为y-x。
 * <p>
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */

public class WeightOfLastStone {
    public static void main(String[] args) {
        WeightOfLastStone weightOfLastStone = new WeightOfLastStone();
        int[] stones = new int[]{2, 4, 2, 6, 7, 10};
        int res = weightOfLastStone.lastStoneWeight(stones);
        System.out.println(res);
    }

    public int lastStoneWeight(int[] stones) {
        // 末尾下标
        int end = stones.length - 1;
        // 已处理的石头数量
        int count = 0;
        while (count != stones.length && count != end) {// 要么全部处理完 要么留一个没处理
            // 先排序
            Arrays.sort(stones);
            int x = stones[end - 1];
            int y = stones[end];
            //x == y，那么两块石头都会被完全粉碎；
            if (x == y) {
                // 粉碎的石头标记为-1
                stones[end - 1] = -1;
                stones[end] = -1;
                // 已处理的石头+2
                count += 2;
            } else {
                stones[end - 1] = stones[end] - stones[end - 1];
                // 粉碎的石头标记为-1
                stones[end] = -1;
                // 已处理的石头+2
                count += 1;
            }
        }
        Arrays.sort(stones);
        // count == stones.length 表示全部处理完返回0 否则剩下一个未处理 返回stones[end]
        return count == stones.length ? 0 : stones[end];
    }
}
