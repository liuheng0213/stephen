package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _03MinNumOfCoins {
    public static void main(String[] args) {
        _03MinNumOfCoins minNumOfCoins = new _03MinNumOfCoins();
        int[] arr = {5, 2, 3};
        int aim = 20;
        int res = minNumOfCoins.minCoins(arr, aim);
        System.out.println(res);
    }

    private int minCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process(arr, 0, aim);
    }

    private int process(int[] arr, int i, int rest) {
        if (arr.length == i) {
            return rest == 0 ? 0 : -1;
        }

        int res = -1;
        for (int k = 0; k * arr[i] <= rest; k++) {
            int next = process(arr, i + 1, rest - k * arr[i]);
            if (next != -1) {
                res = res == -1 ? k + next : Math.min(res, k + next);
            }
        }
        return res;
    }
}
