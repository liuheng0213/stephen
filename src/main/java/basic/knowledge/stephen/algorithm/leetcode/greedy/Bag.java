package basic.knowledge.stephen.algorithm.leetcode.greedy;

//（Ⅰ）最优装载问题

import java.util.Arrays;

/**
 * 有n个物体，第i个物体的重量为wi（wi为正整数）。选择尽量多的物体，使得总重量不超过C。
 * 【分析】由于只关心选择的物品的最大数量（而不是最大重量，最大重量需要考虑DP），
 * 所以装重的物体没有装轻的物体划算。
 * 这里只需对n个物体按重量递增排序，依次选择每个物体直到装不下为止。
 * 这是一种典型的贪心算法，它只顾眼前，却能得到最优解。
 */
public class Bag {
    public static void main(String[] args) {
        Bag bag = new Bag();
        int[] w = new int[]{8, 2, 6, 7, 9, 12, 1};
        int res = bag.maxNum(w, 15);
        System.out.println(res);
    }

    private int maxNum(int[] w, int totalWeight) {
        Arrays.sort(w);
        int count = 0;
        int weight = 0;
        for (int i = 0; i < w.length; i++) {
            count++;
            weight += w[i];
            if (weight > totalWeight) {
                count--;
                return count;
            }
        }
        return count;
    }
}
