package basic.knowledge.stephen.algorithm.greedy;

/**
 * 求和最大的子数组
 * 源自算法导论
 */
public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,97,90};
        int res = solution(arr);
        System.out.println(res);
    }

    private static int solution(int[] arr) {
        int profit = 0;
        int cheapest = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] < arr[cheapest]){
                cheapest = i;
            }

            profit = Math.max(profit,arr[i] - arr[cheapest]);
        }

        return profit;
    }
}
