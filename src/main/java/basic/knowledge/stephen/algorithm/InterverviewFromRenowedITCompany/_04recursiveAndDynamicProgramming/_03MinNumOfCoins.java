package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;


//组成零钱总数的最小钞票数, -1表示找不到组合.
public class _03MinNumOfCoins {
    public static void main(String[] args) {
        _03MinNumOfCoins minNumOfCoins = new _03MinNumOfCoins();
        int[] arr = {5, 2, 3};
        int aim = 20;
        int res = minNumOfCoins.minCoins(arr, aim);
        System.out.println(res);
    }

    private int minCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 1) {
            return -1;
        }
        return process(arr, 0, aim);
    }

    /**
     * 方法含义:
     *  从索引i 开始往后 计算组合成rest的零钱需要多少中方法
     * @param arr
     * @param i
     * @param rest
     * @return
     */
    private int process(int[] arr, int i, int rest) {
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        int res = -1;
        for (int k = 0; rest - k * arr[i] >= 0; k++) {
            int next = process(arr, i + 1, rest - k * arr[i]);
            if (next != -1) {
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;

    }
}
