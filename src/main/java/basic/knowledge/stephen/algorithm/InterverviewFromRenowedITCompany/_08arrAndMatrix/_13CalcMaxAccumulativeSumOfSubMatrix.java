package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

//计算子矩阵的最大累加和
public class _13CalcMaxAccumulativeSumOfSubMatrix {
    public static void main(String[] args) {
        _13CalcMaxAccumulativeSumOfSubMatrix calcMaxAccumulativeSumOfSubMatrix = new _13CalcMaxAccumulativeSumOfSubMatrix();
        int[][] arr = new int[][]{{-90, 48, 78}, {64, -40, 64}, {-81, -7, 66}};
        int res = calcMaxAccumulativeSumOfSubMatrix.getAccSum(arr);
        System.out.println(res);
    }

    private int getAccSum(int[][] arr) {
        int[] auxArr;
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            auxArr = new int[arr[0].length];
            for (int j = i; j < arr.length; j++) {
                cur = 0;
                for (int k = 0; k < arr[j].length; k++) {
                    auxArr[k] += arr[j][k];
                    cur += auxArr[k];
                    cur = cur < 0 ? 0 : cur;
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }
}
