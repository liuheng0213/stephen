package basic.knowledge.stephen.algorithm.leetcode.greedy;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int res = fibonacci.getRes(8);
        System.out.println(res);
    }

    private int getRes(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int res = 1;//n - 1 or n
        int pre = 1;//n - 2 or n - 1
        int tmp = 0;

        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;// f(n) = f(n-1) + f(n -2);
            pre = tmp;//
        }
        return res;
    }
}
