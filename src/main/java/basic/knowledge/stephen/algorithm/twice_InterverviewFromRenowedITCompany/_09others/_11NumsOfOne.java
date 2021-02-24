package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._09others;


//1 到n 中1 出现得次数
public class _11NumsOfOne {
    public static void main(String[] args) {
        _11NumsOfOne numsOfOne = new _11NumsOfOne();
        int res = numsOfOne.getNums(145);
        System.out.println(res);
    }

    private int getNums(int n) {
        if (n < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += getOneNum(i);
        }
        return count;
    }

    private int getOneNum(int n) {
        int res = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                res++;
            }
            n /= 10;
        }
        return res;
    }
}
