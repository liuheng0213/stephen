package basic.knowledge.stephen.algorithm.leetcode.greedy;

public class Leetcode376 {
    public static void main(String[] args) {
        Leetcode376 leetcode376 = new Leetcode376();
        int[] nums = new int[]{1, 7, 4, 9, 2, 5};
        int res = leetcode376.wiggleMaxLength(nums);
        int res1 = leetcode376.wiggleMaxLength_dp(nums);
        System.out.println(res);
    }

    private int wiggleMaxLength_dp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] asc = new int[nums.length];
        int[] des = new int[nums.length];
        asc[0] = nums[0];
        des[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxDes = Integer.MIN_VALUE;
            int maxASC = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxASC = Math.max(maxASC, des[j] + 1);
                }

                if (nums[j] > nums[i]) {
                    maxDes = Math.max(maxDes, asc[j] + 1);
                }
            }
            des[i] = maxDes;
            asc[i] = maxASC;
        }

        return Math.max(des[nums.length - 1], asc[nums.length - 1]);
    }


    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int BEGIN = 0;
        int UP = 1;
        int DOWN = 2;

        int maxlength = 1;
        int status = BEGIN;
        for (int i = 1; i < nums.length; i++) {
            if (status == BEGIN) {
                if (nums[i] > nums[i - 1]) {
                    status = UP;
                    maxlength++;
                } else if (nums[i] < nums[i - 1]) {
                    status = DOWN;
                    maxlength++;
                }
            } else if (status == UP) {
                if (nums[i] < nums[i - 1]) {
                    status = DOWN;
                    maxlength++;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    status = UP;
                    maxlength++;
                }
            }
        }
        return maxlength;
    }
}
