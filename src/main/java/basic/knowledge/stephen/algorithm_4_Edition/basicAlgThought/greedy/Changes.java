package basic.knowledge.stephen.algorithm_4_Edition.basicAlgThought.greedy;

/**
 * 找零钱问题
 * <p>
 * 假设只有 1 分、 2 分、五分、 1 角、二角、 五角、 1元的硬币。在超市结账 时，如果 需要找零钱，
 * 收银员希望将最少的硬币数找给顾客。那么，给定 需要找的零钱数目，如何求得最少的硬币数呢？
 */
public class Changes {
    public static void main(String[] args) {
        double[] d = {0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1.0};
        int[] nums = {33, 45, 120, 86, 30, 19, 11};

        int result = solution(nums, d, 34.6);
        System.out.println(result);
    }

    private static int solution(int[] nums, double[] d, double sum) {
        double total = 0.00;
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    total += d[i] * nums[j];
                }
            }
        }

        if (total < sum) {
            return -1;
        }

        int i = d.length - 1;
        int n = 0;
        int count = 0;
        while (i >= 0) {
            if(sum >= d[i]){
                n = (int) (sum / d[i]);
                if(n >= nums[i]){
                    n = nums[i];
                }
                count += n;
                sum -= n * d[i];
            }
            i--;
        }

        return  count;
    }
}
