package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

//打起球的最大分数
public class _06MaxScoreOfChargingBalloon {


    public static void main(String[] args) {
        _06MaxScoreOfChargingBalloon obj = new _06MaxScoreOfChargingBalloon();
        int[] arr = new int[]{3, 2, 5};
        int res = obj.getRes(arr);
        System.out.println(res);
    }

    private int getRes(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] help = new int[arr.length + 2];
        help[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            help[i + 1] = arr[i];
        }
        help[help.length - 1] = 1;
        //return process(help, 1, help.length - 2);
        return process_POST(help, 1, help.length- 2);
    }

    private int process_POST(int[] help, int left, int right) {
        if (left == right) {
            return help[left - 1] * help[left] * help[right + 1];
        }

        int max = 0;

        //left最后被打爆
        max = Math.max(max, help[left - 1] * help[left] * help[right + 1] + process_POST(help, left + 1, right));
        max = Math.max(max,  help[left - 1] * help[right] * help[right + 1]  + process_POST(help, left, right - 1));

        int temp = 0;
        for (int i = left + 1; i < right; i++) {
            temp = help[left - 1] * help[right + 1] * help[i]
                    + process_POST(help, left, i - 1)
                    + process_POST(help, i + 1, right);
            max = Math.max(max, temp);
        }
        return max;
    }


    private int process_Pre(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L - 1] * arr[L] * arr[R + 1];
        }
        //最后破left
        int res1 = process_Pre(arr, L + 1, R) + arr[L - 1] * arr[L] * arr[R + 1];
        //最后破right
        int res2 = process_Pre(arr, L, R - 1) + arr[L - 1] * arr[R] * arr[R + 1];

        int max = Math.max(res1, res2);

        //最后破i
        for (int i = L + 1; i < R; i++) {
            max = Math.max(max,
                    process_Pre(arr, L, i - 1) + process_Pre(arr, i + 1, R) + arr[L - 1] * arr[i] * arr[R + 1]);
        }

        return max;
    }


    /**
     * 先打爆分析  wrong
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int process(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left - 1] * arr[left] * arr[right];
        }

        int max = 0;

        //left最先被打爆
        /**
         * 这种分析是不对的
         *  arr[left - 1] * arr[left] * arr[left + 1] 之后 进入process(arr, left + 1, right) 之后 并不知道 left已经被爆了 那么回重复计算
         */
        max = Math.max(max, arr[left - 1] * arr[left] * arr[left + 1] + process(arr, left + 1, right));
        max = Math.max(max, arr[right + 1] * arr[right] * arr[right - 1] + process(arr, left, right - 1));

        int temp = 0;
        for (int i = left + 1; i < right; i++) {
            temp = arr[i - 1] * arr[i + 1] * arr[i]
                    + process(arr, left, i - 1)
                    + process(arr, i + 1, right);
            max = Math.max(max, temp);
        }
        return max;
    }


}
