package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

public class Leetcode659 {
    public static void main(String[] args) {
        Leetcode659 leetcode659 = new Leetcode659();
        int[] nums = new int[]{1, 3, 3, 4, 4, 7, 8, 8, 9, 10};
        int[] nums1 = new int[]{1, 2, 3, 3, 4, 4, 5, 5};
        int[] nums2 = new int[]{1};
        int[] nums3 = new int[]{1, 2, 3, 3, 4, 5};
        int[] nums4 = new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10, 11};
        int[] nums5 = new int[]{4, 5, 6, 7, 7, 8, 8, 9, 10, 11};
        int[] nums6 = new int[]{1, 2, 3, 4, 4, 5, 6};
        int[] nums7 = new int[]{1, 1, 2, 2, 3, 3, 5, 6};
        //boolean possible = leetcode659.isPossible(nums5);
        boolean possible1 = leetcode659.isPossible_better(nums7);
        System.out.println(possible1);
    }

    /**
     * 采用贪心算法，优先和前面的组队，因为和后面的组队会出现单独的一个或者两个
     * 另外代码中get方法改成getOrdefault方法，因为直接用get可能会空指针
     * 代码：
     *
     * @param nums
     * @return
     */
    private boolean isPossible_better(int[] nums) {
        //用来记录每个数字出现的次数
        HashMap<Integer, Integer> numCount = new HashMap<>();
        //用来计算以这个数用于结尾的连续的次数
        HashMap<Integer, Integer> tails = new HashMap<>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            //如果为0则跳过
            if (numCount.getOrDefault(num, 0) == 0) {
                continue;
                //如果大于0，并且前面有连续的，优先和前面组队，因为和后面组队
                //和可能出现一个和两个的情况
            } else if (tails.getOrDefault(num - 1, 0) > 0) {
                numCount.put(num, numCount.getOrDefault(num, 0) - 1);
                tails.put(num - 1, tails.getOrDefault(num - 1, 0) - 1);
                tails.put(num, tails.getOrDefault(num, 0) + 1);
                //如果不能和前面组队，那么就和后面组队
            } else if (numCount.getOrDefault(num + 1, 0) > 0
                    && numCount.getOrDefault(num + 2, 0) > 0) {
                numCount.put(num, numCount.getOrDefault(num, 0) - 1);
                numCount.put(num + 1, numCount.getOrDefault(num + 1, 0) - 1);
                numCount.put(num + 2, numCount.getOrDefault(num + 2, 0) - 1);
                tails.put(num + 2, tails.getOrDefault(num + 2, 0) + 1);
                //i前面和后面都不能组队，那么它指定是单独的了
            } else {
                return false;
            }
        }
        return true;

    }

    public boolean isPossible(int[] nums) {


        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> tails = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        for (int x : nums) {
            if (count.get(x) == 0)
                continue;
            else if (tails.containsKey(x) && tails.get(x) > 0) {
                tails.put(x, tails.getOrDefault(x, 0) - 1);
                tails.put(x + 1, tails.getOrDefault(x + 1, 0) + 1);
            } else if (count.containsKey(x + 1) && count.get(x + 1) > 0
                    && count.containsKey(x + 2) && count.get(x + 2) > 0) {
                count.put(x + 1, count.get(x + 1) - 1);
                count.put(x + 2, count.get(x + 2) - 1);
                tails.put(x + 3, tails.getOrDefault(x + 3, 0) + 1);
            } else {
                return false;
            }
            count.put(x, count.get(x) - 1);
        }
        return true;


    }
}
