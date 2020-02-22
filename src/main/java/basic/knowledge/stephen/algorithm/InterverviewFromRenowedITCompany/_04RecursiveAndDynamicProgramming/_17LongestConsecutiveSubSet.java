package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

import java.util.HashMap;

public class _17LongestConsecutiveSubSet {
    public static void main(String[] args) {
        _17LongestConsecutiveSubSet longestSeriasSubSet = new _17LongestConsecutiveSubSet();
        int[] arr = new int[]{100, 4, 200, 3, 19, 6, 5, 1, 34, 2};
        int[] arr1 = new int[]{100, 4, 200, 1, 3, 2};
        int res = longestSeriasSubSet.longestConsecutive(arr1);
        System.out.println(res);

    }

    /**
     * hashmap key 记录序列中的数， value记录数所在的序列长度
     * 仅考虑或更新首尾
     *
     * @param arr
     * @return
     */
    private int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
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
        //这个分析是错误的 有可能 都不为1  因为上面的方法不是 if else 两个if 都要判断的
        // map一轮会有 最后会有 1--》2；2--》2；3--》2,4--》2
        //less == 2, more ==3
       /* int left;
        int right;
        if (map.get(less) == 1) {     //小的进
            left = less;
            right = more + map.get(more) - 1;
        } else {
            right = more;
            left = less - map.get(less) + 1;
        }*/

        /**
         * less 的
         * map存储的是value 是key 元素对左边的子连续序列长度
         *
         * more 的
         * map存储的是value 是key 元素对右边的子连续序列长度
         */

        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;

        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }
}
