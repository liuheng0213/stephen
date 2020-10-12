package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _01Fibonacci {
    public static void main(String[] args) {
        _01Fibonacci fibonacci = new _01Fibonacci();
        int res = fibonacci.getRes(21);
        System.out.println(res);
    }

    //需要做一个带cp的
    //todo
    private int getRes(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int res = 2;
        int pre = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res = res + pre;
            pre = temp;
        }
        return res;
    }


}
