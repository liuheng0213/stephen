package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

public class _06MaxScoreOfChargingBalloon {
    public static void main(String[] args) {
        _06MaxScoreOfChargingBalloon maxScoreOfChargingBalloon = new _06MaxScoreOfChargingBalloon();
        int[] arr = new int[]{3, 2, 5, 6};
        int[] help = new int[arr.length + 2];
        help[0] = 1;
        help[help.length - 1] = 1;
        for (int i = 0; i < arr.length; i++) {
            help[i + 1] = arr[i];
        }
        int res = maxScoreOfChargingBalloon.process(help, 1, arr.length);
        System.out.println(res);
    }

    private int process(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left - 1] * arr[left] * arr[right + 1];
        }
        //最后破left
        int res1 = process(arr, left + 1, right) + arr[left - 1] * arr[left] * arr[right + 1];
        //最后破right
        int res2 = process(arr, left, right - 1) + arr[left - 1] * arr[right] * arr[right + 1];

        int max = Math.max(res1, res2);

        //最后破i
        for (int i = left + 1; i < right; i++) {
            max = Math.max(max,
                    process(arr, left, i - 1) + process(arr, i + 1, right) + arr[left - 1] * arr[i] * arr[right + 1]);
        }

        return max;
    }

}
