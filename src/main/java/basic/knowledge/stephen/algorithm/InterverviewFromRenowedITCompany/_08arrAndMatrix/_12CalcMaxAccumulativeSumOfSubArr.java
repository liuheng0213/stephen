package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

//计算子数组的最大累加和
public class _12CalcMaxAccumulativeSumOfSubArr {
    public static void main(String[] args) {
        _12CalcMaxAccumulativeSumOfSubArr calcMaxAccumulativeSumOfSubArr = new _12CalcMaxAccumulativeSumOfSubArr();
        int[] arr = new int[]{1, -2, 3, 5, -2, 6, -1, 3};
        int res = calcMaxAccumulativeSumOfSubArr.getMaxSum(arr);
        System.out.println(res);
    }

    private int getMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(max,cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
