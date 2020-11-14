package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

//计算子矩阵的最大累加和
public class _13CalcMaxAccumulativeSumOfSubMatrix {
    public static void main(String[] args) {
        _13CalcMaxAccumulativeSumOfSubMatrix calcMaxAccumulativeSumOfSubMatrix = new _13CalcMaxAccumulativeSumOfSubMatrix();
        int[][] arr = new int[][]{{-90, 48, 78, 77}, {64, -40, 64, 79}, {-81, -7, 66, 79}};
        int res = calcMaxAccumulativeSumOfSubMatrix.getAccSum(arr);
        System.out.println(res);
    }

    private int getAccSum(int[][] arr) {
        int[] healpArr = new int[arr[0].length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            healpArr = new int[arr[0].length];
            for (int j = i; j < arr.length; j++) {
                int cur = 0;
                for (int k = 0; k < arr[0].length; k++) {
                    healpArr[k] += arr[j][k];
                    cur += healpArr[k];
                    max = Math.max(cur, max);
                    cur = cur < 0 ? 0 : cur;
                }
            }

        }
        return max;
    }
}
