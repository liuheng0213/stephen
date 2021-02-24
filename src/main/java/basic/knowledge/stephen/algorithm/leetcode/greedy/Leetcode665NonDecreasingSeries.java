package basic.knowledge.stephen.algorithm.leetcode.greedy;

//Leetcode_665. 非递减数列

/**
 * 题目描述：
 * <p>
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * <p>
 * 说明: n 的范围为 [1, 10,000]。
 */
public class Leetcode665NonDecreasingSeries {
    public static void main(String[] args) {
        Leetcode665NonDecreasingSeries nonDecreasingSeries = new Leetcode665NonDecreasingSeries();
        int[] arr = new int[]{5,12,7};
        boolean flag = nonDecreasingSeries.checkPossibility(arr);
        System.out.println(flag);
    }

    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int i = 1; i < length && count < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            count++;

            /**
             * 贪心的策略  体现的很好  下面的两个条件我都只改变了 一次  且尽量不影响后面的改动次数
             */
            //接下来 要改了  非递减 要考察 三个数 i 要大于等于i - 1  还要大于等于 i  - 2
            //由于只能改一个数 : i -2  i- 1 都比 i  大 那么当然改 i 了
            if (i >= 2 && nums[i - 2] > nums[i]) {
                // 使当前数字等于前一个数字
                nums[i] = nums[i - 1];
            }
            //只有i - 1  比 i 大 当然改  i  - 1  了
            else {
                // 使前一个数字小于当前数字
                // 为什么这里不像上面 If 那样?
                // 因为能不提高nums[i]  就不提高 否则提高nums[i] 影响后面的改动次数过大
                nums[i - 1] =  nums[i];
            }
        }
        return count <= 1;
    }
}
