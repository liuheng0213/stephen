package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;


import java.util.Arrays;
import java.util.HashSet;

//正整数数组的最小不可能
public class _09ImpossibleMinSum {
    public static void main(String[] args) {
        _09ImpossibleMinSum impossibleMinSum = new _09ImpossibleMinSum();
        int[] arr = new int[]{3, 2, 5, 2, 6, 8};
        int[] arr1 = new int[]{3, 2, 1};
        int res1 = impossibleMinSum.unformedSum1(arr);
        int res2 = impossibleMinSum.unformedSum2Compress(arr);
        System.out.println(res1 == res2);
        System.out.println(res2);
//        int res3 = impossibleMinSum.unformedSum3withFirstOne(arr1);
//        System.out.println(res3);


    }

    /**
     * 数组一定含有1 这个元素
     *
     * @param arr
     * @return
     */
    private int unformedSum3withFirstOne(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        Arrays.sort(arr);
        int range = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > range + 1) {
                return range + 1;
            } else {
                range += arr[i];
            }
        }
        return range + 1;
    }



    /**
     * 动态规划法
     *
     * @param arr
     * @return
     */
    public int unformedSum2Compress(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        //区间下限 百分之百的是arr 中的最小值
        //区间上限 ,肯定是所有元素之和
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            sum += arr[i];
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = arr.length - 1; i >= 0; i--) {
          /*  for (int j = arr[i]; j <= sum; j++) {
                dp[j] = dp[j - arr[i]] ? true : dp[j];
            }*/
            for (int j = sum; j >= arr[i]; j--) {
                dp[j] = dp[j - arr[i]] ? true : dp[j];
            }
        }
        for (int i = min; i < dp.length; i++) {
            if (!dp[i]) {
                return i;
            }
        }
        return sum + 1;
    }

    public int unformedSum1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        HashSet<Integer> set = new HashSet<>();
        process(arr, 0, 0, set);

        int min = Integer.MAX_VALUE;
        int max = 0;
        //区间下限 百分之百的是arr 中的最小值
        //区间上限 ,肯定是所有元素之和
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max += arr[i];
        }
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) { //min max 肯定在set里
                return i;
            }
        }
        return max + 1;
    }

    /**
     * 从i开始往后走, 找到所有可能的子数组 并求和 放入set中
     *
     * @param arr
     * @param i
     * @param sum
     * @param set
     */
    private void process(int[] arr, int i, int sum, HashSet<Integer> set) {
        if (i == arr.length) {
            set.add(sum);
            return;
        }
        //包含当前数arr[i]的情况, 没有下面的process 就只是0
        process(arr, i + 1, sum, set);
        //不包含当前数arr[i]的情况, 如果没有上面 就是所有的总求和
        process(arr, i + 1, sum + arr[i], set);
    }
}
