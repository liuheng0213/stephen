package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._09others;

//最大的leftMAX和rightMAX之差的绝对值
public class _05AbsOfLeftMaxAndRightMax {
    public static void main(String[] args) {
        _05AbsOfLeftMaxAndRightMax absOfLeftMaxAndRightMax = new _05AbsOfLeftMaxAndRightMax();
        int[] arr = new int[]{2, 7, 3, 1, 1, 5, 10, 100};
        int res1 = absOfLeftMaxAndRightMax.method1(arr);
        System.out.println(res1);
        int res2 = absOfLeftMaxAndRightMax.method2(arr);
        System.out.println(res2);
        int res3 = absOfLeftMaxAndRightMax.method3(arr);
        System.out.println(res3);
        System.out.println(res1 == res2 && res2 == res3);
    }

    /**
     * o(n) o(1)
     *
     * @param arr
     * @return
     */
    private int method3(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max - Math.min(arr[0], arr[arr.length - 1]);
    }

    /**
     * o(n)  o(n)
     * 这个方法很重要 : 预处理数组
     *
     * @param arr
     * @return
     */
    private int method2(int[] arr) {
        int res = Integer.MIN_VALUE;
        int[] leftMAXes = new int[arr.length];
        int[] rightMAXes = new int[arr.length];
        leftMAXes[0] = arr[0];
        rightMAXes[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            leftMAXes[i] = Math.max(leftMAXes[i - 1], arr[i]);
        }
        for (int i = arr.length - 2; i > -1; i--) {
            rightMAXes[i] = Math.max(rightMAXes[i + 1], arr[i]);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            res = Math.max(res, Math.abs(leftMAXes[i] - rightMAXes[i + 1]));
        }
        return res;
    }

    /**
     * o(n^2)
     *
     * @param arr
     * @return
     */
    private int method1(int[] arr) {
        int res = Integer.MIN_VALUE;
        int leftMAX = 0;
        int rightMAX = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            leftMAX = Integer.MIN_VALUE;
            for (int j = 0; j < i + 1; j++) {
                leftMAX = Math.max(leftMAX, arr[j]);
            }
            rightMAX = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                rightMAX = Math.max(rightMAX, arr[j]);
            }
            res = Math.max(res, Math.abs(leftMAX - rightMAX));
        }
        return res;
    }
}

