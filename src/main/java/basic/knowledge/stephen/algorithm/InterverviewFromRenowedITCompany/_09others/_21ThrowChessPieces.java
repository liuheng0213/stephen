package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

//丢棋子问题
public class _21ThrowChessPieces {
    public static void main(String[] args) {
        _21ThrowChessPieces throwChessPieces = new _21ThrowChessPieces();
        int res = throwChessPieces.solution1(13, 2);
        int res1 = throwChessPieces.solution2(13, 2);
        System.out.println(res);
        System.out.println(res1);
    }

    private int solution2(int n, int k) {
        if (n < 1 || k < 1) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        //dp[i][j] i 个楼层在 k 个棋子在最差情况下返回的扔下的最少 次数
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i != dp.length; i++) {
            dp[i][1] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 2; j != dp[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int m = 1; m <= i; m++) {
                    min = Math.min(min, Math.max(dp[m - 1][j - 1], dp[i - m][j]));
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[n][k];
    }

    private int solution1(int N, int K) {
        if (N < 1 || K < 1) {
            return 0;
        }

        return process(N, K);
    }

    private int process(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, 1 + Math.max(process(i - 1, k - 1), process(n - i, k)));
        }
        return res;
    }
}
