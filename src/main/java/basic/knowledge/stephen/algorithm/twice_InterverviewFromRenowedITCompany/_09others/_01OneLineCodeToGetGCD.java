package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._09others;


//一行代码求出最大公约数(greatest common divisor)
//m = nq+r
//那么 m, n 的最大公约数 = n ,r 的最大公约数
public class _01OneLineCodeToGetGCD {
    public static void main(String[] args) {
        _01OneLineCodeToGetGCD oneLineCodeToGetGCD = new _01OneLineCodeToGetGCD();
        int res = oneLineCodeToGetGCD.gcd(22,11);
        System.out.println(res);
    }

    private int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
