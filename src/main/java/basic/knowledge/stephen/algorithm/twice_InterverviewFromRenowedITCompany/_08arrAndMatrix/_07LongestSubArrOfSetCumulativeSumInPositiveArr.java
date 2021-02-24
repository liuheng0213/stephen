package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._08arrAndMatrix;


//未排序正数组中累加和为给定值的最长子数组长度(数组元素为正)
//可以用_08做  但那不是最优解
//双指针题
public class _07LongestSubArrOfSetCumulativeSumInPositiveArr {
    public static void main(String[] args) {
        _07LongestSubArrOfSetCumulativeSumInPositiveArr longestSubArrOfSetCumulativeSumInPositiveArr = new _07LongestSubArrOfSetCumulativeSumInPositiveArr();
        int[] arr = new int[]{1, 2, 3, 1, 1,1};
        int res = longestSubArrOfSetCumulativeSumInPositiveArr.getMaxLen(arr, 6);
        System.out.println(res);
    }
    //单方向  快慢指针 只往前看, 不往后看  快指针到达右边界为结束
    private int getMaxLen(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        //我这个肯定错 根i 遍历没任何关系  类似这种题 只能用while  不可以用for 语义不明
//        for (int i = 0; i < arr.length; i++) {
//            if (sum == k) {
//                len = Math.max(len, right - left + 1);
//                sum -= arr[left++];
//            } else if (sum < k) {
//                right++;
//                if (right == arr.length) {
//                    break;
//                }
//                sum += arr[right];
//            } else {
//                sum -= arr[left++];
//            }
//        }
        return len;
    }
}
