package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

//邮局选址问题
public class _23PostOfficeAddresses {
    public static void main(String[] args) {
        _23PostOfficeAddresses postOfficeAddresses = new _23PostOfficeAddresses();
        int[] arr = new int[]{-3, -2, -1, 0, 1, 2};
        int res = postOfficeAddresses.solution(arr, 3);
        System.out.println(res);
    }

    private int solution(int[] arr, int num) {
        if (arr == null || num < 1 || arr.length < num) {
            return 0;
        }

        //要申请n+ 1  n + 1的二维数组  防止 j = i + 1  越界
        int[][] w = new int[arr.length + 1][arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                w[i][j] = w[i][j - 1] + arr[j] - arr[(i + j) / 2];
            }
        }

        //dp[i][j] 含义 : arr[0...j] 上建设i个邮局的情况下, 总距离最少是多少
        //所以只考虑 j > i 的情况  i >= j时  最少总距离为0
        int[][] dp = new int[num + 1][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[1][i] = w[0][i];
        }

        for (int i = 2; i <= num; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k <= j; k++) {
                    min = Math.min(min, dp[i - 1][k] + w[k + 1][j]);
                }
                dp[i][j] = min;
            }
        }


        return dp[num][arr.length - 1];
    }
}
