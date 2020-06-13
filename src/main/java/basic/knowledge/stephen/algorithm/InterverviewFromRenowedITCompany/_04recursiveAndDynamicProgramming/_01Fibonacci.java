package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _01Fibonacci {
    public static void main(String[] args) {
        _01Fibonacci fibonacci = new _01Fibonacci();
        int res = fibonacci.getRes(8);
        System.out.println(res);
    }

    private int getRes(int n) {
        if (n == 0) {
            return 0;
        }



        if (n == 1 ) {
            return 1;
        }

        if(n == 2){
            return 2;
        }


        int res = 2;//n - 1 or n
        int pre = 1;//n - 2 or n - 1
        int tmp = 0;

        for (int i = 3; i <= n; i++) {
            tmp = res; //指向f(n - 1)
            res = res + pre;// f(n) = f(n-1) + f(n -2);
            pre = tmp; //pre 就是之前的res
        }
        return res;
    }
}
