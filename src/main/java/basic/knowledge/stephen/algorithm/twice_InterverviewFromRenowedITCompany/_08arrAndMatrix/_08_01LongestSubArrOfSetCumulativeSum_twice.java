package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.HashMap;

public class _08_01LongestSubArrOfSetCumulativeSum_twice {
    public static void main(String[] args) {
        _08_01LongestSubArrOfSetCumulativeSum_twice obj = new _08_01LongestSubArrOfSetCumulativeSum_twice();
        int[] arr = new int[]{1, 2, 3, 3};
        int res = obj.maxLength(arr, 6);
        System.out.println(res);
    }

    private int maxLength(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 1) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(target - sum)) {
                maxLen = Math.max(maxLen, i - map.get(target - sum));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
