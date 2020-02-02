package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

public class _04RobotGetDestination {
    public static void main(String[] args) {
        _04RobotGetDestination robotGetDestination = new _04RobotGetDestination();
        int res = robotGetDestination.ways(5, 2, 3, 3);
        System.out.println(res);
    }

    /**
     * @param N 排成一行的N哥位置  固定值
     * @param M 开始时的位置 递归里的当前位置
     * @param K 机器人必须走N步  递归里的剩余步数
     * @param P 最后停下来的位置  固定值
     * @return
     */
    private int ways(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return walk(N, M, K, P);
    }

    private int walk(int n, int cur, int rest, int p) {
        if (rest == 0) {
            return cur == p ? 1 : 0;
        }
        if (cur == 1) {
            return walk(n, 2, rest - 1, p);
        }
        if (cur == n) {
            return walk(n, n - 1, rest - 1, p);
        }
        return walk(n, cur + 1, rest - 1, p) + walk(n, cur - 1, rest - 1, p);
    }
}
