package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04RecursiveAndDynamicProgramming;

public class _16GameOfFormingLineByCards {
    public static void main(String[] args) {
        _16GameOfFormingLineByCards gameOfFormingLineByCards = new _16GameOfFormingLineByCards();
        int[] arr = new int[]{1, 2, 100, 4, 45, 3, 19};
        int res = gameOfFormingLineByCards.win(arr);
        System.out.println(res);
    }

    private int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    /**
     * 先走
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        } else {
            return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
        }

    }

    /**
     * 后走
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }

        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }
}
