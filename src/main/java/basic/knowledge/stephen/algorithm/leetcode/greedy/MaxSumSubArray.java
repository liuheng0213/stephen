package basic.knowledge.stephen.algorithm.leetcode.greedy;

/**
 * 低买高卖股票  找到哪个时段的最大利润
 * 源自算法导论
 */
public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{100, 113, 110, 85, 86, 88, 185, 96};
        int res = solution(arr);
        System.out.println(res);
    }

    private static int solution(int[] arr) {
        int profit = 0;
        int cheapest = 0;
        for (int i = 0; i < arr.length; i++) {
            //  i  总是大于等于  cheapest 的
            if (arr[i] < arr[cheapest]) {
                cheapest = i;
            }

            profit = Math.max(profit, arr[i] - arr[cheapest]);
        }

        return profit;
    }
}
