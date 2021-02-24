package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
        boolean possible = leetcode659.isPossible(nums5);
        System.out.println(possible);
    }



    /**
     * 这是个可读性很高的方法:
     * 思路：哈希表+最小堆。只要知道序列的最后一个数值和子序列长度就可以确定子序列。
     * 因此用哈希表存储最后一个元素和子序列长度。
     * 但可能出现多个以相同数字为结尾，如“5,5,5,5,5,5”，那么哈希表将无法直接使用。
     * 将哈希表的value存储为优先队列，队列元素代表长度，
     * 因为，数值x需要寻找以x-1为结尾的子序列，当出现多个x-1为结尾的子序列时，
     * 那么应该优先考虑较短的那个，因为题目要求长度至少为3。
     *
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {


        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, new PriorityQueue<>());
            }
            if (map.containsKey(n - 1)) {
                int t = map.get(n - 1).poll();// 这是最短的  先拿出来搞定
                if (map.get(n - 1).isEmpty()) {
                    map.remove(n - 1);
                }
                map.get(n).add(t + 1);
            } else {
                map.get(n).add(1);
            }
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> s : map.entrySet()) {
            if (s.getValue().peek() < 3) {
                return false;
            }
        }
        return true;


    }
}
