package basic.knowledge.stephen.algorithm.leetcode.greedy;

public class Leetcode376 {
    public static void main(String[] args) {
        Leetcode376 leetcode376 = new Leetcode376();
        int[] nums = new int[]{1, 7, 4, 9, 2, 5,8};
        int res = leetcode376.wiggleMaxLength(nums);
        int res1 = leetcode376.wiggleMaxLength_dp(nums);
        System.out.println(res == res1);
    }

    private int wiggleMaxLength_dp(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] up = new int[nums.length];
        int[] down= new int[nums.length];
        up[0] = down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
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
