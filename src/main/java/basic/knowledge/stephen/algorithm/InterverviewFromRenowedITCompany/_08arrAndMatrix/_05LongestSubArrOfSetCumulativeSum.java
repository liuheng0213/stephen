package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.HashMap;
import java.util.Map;

public class _05LongestSubArrOfSetCumulativeSum {
    public static void main(String[] args) {
        _05LongestSubArrOfSetCumulativeSum longestSubArrOfSetCumulativeSum = new _05LongestSubArrOfSetCumulativeSum();
        int[] arr = new int[]{1, 2, 3, 3};
        int res = longestSubArrOfSetCumulativeSum.maxLength(arr, 6);
        System.out.println(res);
    }

    /**
     * map 记录sum 和 这个sum第一次出现的arr的下标
     * len 记录要求的最长子数组
     *
     * @param arr
     * @return
     */
    private int maxLength(int[] arr, int k) {
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);// very important!
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
           /* if (map.containsKey(sum - k)) {
                len = Math.max(len, i - (map.get(sum - k) == -1 ? 0 : map.get(sum - k)) + 1);
            }*/
        }
        return len;
    }
}
