package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.HashSet;
import java.util.Set;

//最长可整合数组 贪心算法
public class _05LongestIntegratableArr {
    public static void main(String[] args) {
        _05LongestIntegratableArr longestIntegratableArr = new _05LongestIntegratableArr();
        int[] arr = new int[]{5, 5, 3, 2, 6, 4, 3};
        int res = longestIntegratableArr.findRes(arr);
        System.out.println(res);
    }

    private int findRes(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = 0;
        int max = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            Set<Integer> mark = new HashSet<>();
            for (int j = i; j < arr.length; j++) {
                if (mark.contains(arr[j])) {
                    break;
                }
                mark.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if (max - min == j - i) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }
}
