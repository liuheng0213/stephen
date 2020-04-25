package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;
//本地不可能动态规划  因为每一次i 值都要递归
public class _19NQueens {
    public static void main(String[] args) {
        _19NQueens nQueens = new _19NQueens();
        int res = nQueens.getNum(15);
        System.out.println(res);
    }

    /**
     * record[i]  表示第i行皇后  所在的列数
     * record[1] = 4, 表示  （1,4）有棋子
     * 思路 递归深度 为i   数组遍历  为j
     *
     * @param n
     * @return
     */
    private int getNum(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    /**
     * 方法意义;
     *
     * @param i
     * @param record
     * @param n
     * @return
     */
    private int process(int i, int[] record, int n) {
        if (i == n) {  //i 最大为n - 1
            return 1;
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;

    }

    /**
     * d对于 k from 0 to i 和j 是否OK
     *
     * @param record
     * @param i
     * @param j
     * @return
     */
    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(k - i) == Math.abs(record[k] - j)) {
                return false;
            }
        }
        return true;
    }
}
