package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._09others;

public class _21ThrowChessPieces_twice {
    public static void main(String[] args) {
        _21ThrowChessPieces_twice throwChessPieces = new _21ThrowChessPieces_twice();
        int res = throwChessPieces.solution1Recur(13, 2);
        System.out.println(res);
        int res1 = throwChessPieces.solution2(13, 2);
        System.out.println(res1);
    }

    private int solution2(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j == 1) {
                    dp[i][j] = i;
                } else {
                    int temp;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int s = 1; s <= i; s++) {
                        temp = Math.max(dp[s - 1][j - 1] + 1, dp[i - s][j] + 1);
                        dp[i][j] = Math.min(dp[i][j], temp);
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    private int solution1Recur(int n, int k) {
        if (n == 0) {
            return 0;
        }

        if (k == 1) {
            return n;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(solution1Recur(i - 1, k - 1) + 1, solution1Recur(n - i, k) + 1));
        }
        return res;
    }
}
