package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

//给一个整数N  表示字符0 或 1 组成的N 长度的字符 且0 的左边必须是1 求一共又多少中组合
public class _16leftSideOf1Is0 {
    public static void main(String[] args) {
        _16leftSideOf1Is0 obj = new _16leftSideOf1Is0();
        System.out.println(obj.getres(8)==obj.getResByRecur(8));
    }
    public int getResByRecur(int N) {
        if (N < 1) {
            return 0;
        }
        return process(1, N);
    }

    private int process(int i, int n) {
        if (i == n - 1) {
            return 2;// 10 11
        }
        if (i == n) {
            return 1;
        }

        return process(i + 1, n) + process(i + 2, n);
    }

    // dp[i] 为 0~i-1 都确定了且第i -1 位为1时  i~N 共有多少种组合方法
    // 1 当i  为1 时 dp[i] = dp[i + 1]
    //2 当 i 为0 时,  i + 1 必为 1 则dp[i] = dp[i + 2]
    public int getres(int N) {
        if (N < 1) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int pre = 1;
        int cur = 2;
        int temp = 0;
        for (int i = 2; i < N; i++) {
            temp = cur;
            cur = cur + pre;
            pre = temp;
        }
        return cur;
    }
}
