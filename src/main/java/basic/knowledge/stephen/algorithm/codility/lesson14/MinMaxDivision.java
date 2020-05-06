package basic.knowledge.stephen.algorithm.codility.lesson14;

//最小大和
//给定正整数数组
//求最大中的最小，或者最小中的最大，要么是二分，要么是动态规划。
public class MinMaxDivision {
    public static void main(String[] args) {
        MinMaxDivision minMaxDivision = new MinMaxDivision();
        int[] arr = new int[]{2, 1, 5, 1, 2, 2, 2};
        int res = minMaxDivision.solution(3, arr);//k 划分快数
        int res1 = minMaxDivision.solution_dp(3, arr);//k 划分快数
        System.out.println(res);
    }

    /**
     * dp[i] 含义 i----arr.length
     *
     * @param k
     * @param arr
     * @return
     */
    private int solution_dp(int k, int[] arr) {
        return 0;
    }

    private int solution(int K, int[] arr) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
            left = Math.max(left, arr[i]);
            right += arr[i];
        }
        //最大和值一点在left 和right之间
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isTrue(arr, mid, K)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //二分中的判断条件就是该数组是否可以划分小于等于k个块，并且每个块的和都小于等于mid(sum)
    //如果符合条件，说 明mid的值是过大的，还可以再小一点，end=mid-1;
    //如果不符合条件，说明mid的值是过小的，start=mid+1;
    private boolean isTrue(int[] arr, int sum, int k) {
        int ks = 0;
        int tempSum = 0;
        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            if (tempSum > sum) {
                tempSum = 0;
                ks++;
                i--;
            }
        }

        if (tempSum > 0) {
            ks++;
        }

        if (ks <= k) {
            return true;
        }
        return false;
    }
}
