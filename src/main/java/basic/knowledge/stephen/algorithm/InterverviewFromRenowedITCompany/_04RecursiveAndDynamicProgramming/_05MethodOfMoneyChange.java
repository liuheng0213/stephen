package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

public class _05MethodOfMoneyChange {
    public static void main(String[] args) {
        _05MethodOfMoneyChange methodOfMoneyChange = new _05MethodOfMoneyChange();
        int[] arr = new int[]{5, 10, 25, 1,100,50};
        int methods = methodOfMoneyChange.getRes(arr, 45);
        System.out.println(methods);
    }

    private int getRes(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    private int process(int[] arr, int k, int aim) {
        if (arr.length == k) {
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; i * arr[k] <= aim; i++) {
            int restRes = process(arr, k + 1, aim - i * arr[k]);
            res = res + restRes;
        }
        return res;
    }
}
