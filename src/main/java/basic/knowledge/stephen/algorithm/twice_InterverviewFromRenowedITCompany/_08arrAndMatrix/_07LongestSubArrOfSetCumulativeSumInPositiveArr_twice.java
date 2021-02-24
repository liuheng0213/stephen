package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._08arrAndMatrix;

public class _07LongestSubArrOfSetCumulativeSumInPositiveArr_twice {
    public static void main(String[] args) {
        _07LongestSubArrOfSetCumulativeSumInPositiveArr_twice obj = new _07LongestSubArrOfSetCumulativeSumInPositiveArr_twice();
        int[] arr = new int[]{1, 2, 3, 1, 1, 1};
        int res = obj.getMaxLen(arr, 3);
        System.out.println(res);
    }

    private int getMaxLen(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 1) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen = 0;
        while (right < arr.length) {
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
                sum -= arr[left++];
            } else if (sum < target) {
                right++;
                if(right == arr.length){
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return maxLen;
    }
}
