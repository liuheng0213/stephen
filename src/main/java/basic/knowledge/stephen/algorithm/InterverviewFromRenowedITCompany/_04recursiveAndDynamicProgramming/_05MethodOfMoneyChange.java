package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _05MethodOfMoneyChange {
    public static void main(String[] args) {
        _05MethodOfMoneyChange methodOfMoneyChange = new _05MethodOfMoneyChange();
        int[] arr = new int[]{5, 10, 25, 1, 100, 50};
        int methods = methodOfMoneyChange.getRes(arr, 35);
        System.out.println(methods);
    }

    private int getRes(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process2(arr, arr.length - 1, aim);
    }

    /**
     * 方法含义:
     * 从索引k 开始往后 计算和为aim的所有组合方法
     *
     * @param arr
     * @param k
     * @param aim
     * @return
     */
    private int process(int[] arr, int k, int aim) {
        if (k == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; i * arr[k] <= aim; i++) {
            res += process(arr, k + 1, aim - i * arr[k]);
        }
        return res;
    }

    /**
     * *方法含义:
     * 从索引0开始往后到K  计算和为aim的所有组合方法
     *
     * @param arr
     * @param k
     * @param aim
     * @return
     */
    private int process2(int[] arr, int k, int aim) {
        //当然也可以  k == -1 为收敛条件 但是dp 没有 -1 的索引
        if (k == 0) {
            int res = 0;
            for (int i = 0; i * arr[k] <= aim; i++) {
                if (i * arr[k] == aim) {
                    res++;
                }
            }
            return res;
        }
        int res = 0;
        for (int i = 0; i * arr[k] <= aim; i++) {
            res += process2(arr, k - 1, aim - i * arr[k]);
        }
        return res;
    }
}
