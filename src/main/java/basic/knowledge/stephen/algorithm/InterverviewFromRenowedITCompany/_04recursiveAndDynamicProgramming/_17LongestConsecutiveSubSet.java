package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

import java.util.HashMap;

//数组中的最长连续序列
public class _17LongestConsecutiveSubSet {
    public static void main(String[] args) {
        _17LongestConsecutiveSubSet longestSeriasSubSet = new _17LongestConsecutiveSubSet();
        int[] arr = new int[]{100, 4, 200, 3, 19, 6, 5, 1, 34, 2};
        int[] arr1 = new int[]{100, 4, 200, 1, 3, 2};
        int[] arr2 = new int[]{3, 4, 2};
        int res = longestSeriasSubSet.longestConsecutive(arr2);
        System.out.println(arr1);

    }

    /**
     * hashmap key 记录序列中的数， value记录数所在的序列长度
     * 仅考虑或更新首尾
     *
     * @param arr
     * @return
     */
    private int longestConsecutive(int[] arr) {
        if (arr == null) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                if (map.containsKey(arr[i] - 1)) {
                    max = Math.max(max, getNewMaxLen(map, arr[i] - 1, arr[i]));
                }
                if (map.containsKey(arr[i] + 1)) {
                    max = Math.max(max, getNewMaxLen(map, arr[i], arr[i] + 1));
                }
            }
        }
        return max;
    }

    private int getNewMaxLen(HashMap<Integer, Integer> map, int less, int more) {
        //要么 map.get(less) == 1 (less 为新加入) 要么 map.get(more) == 1(more 为新加入)
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }
}
