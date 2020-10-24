package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;


//排成一条线的纸牌博弈问题
public class _16GameOfFormingLineByCards {
    public static void main(String[] args) {
        _16GameOfFormingLineByCards gameOfFormingLineByCards = new _16GameOfFormingLineByCards();
        int[] arr = new int[]{1, 2, 100, 4, 45, 3, 19, 200};
        int res = gameOfFormingLineByCards.win(arr);
        System.out.println(res);
    }

    private int win(int[] arr) {
        if (arr == null) {
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1), last(arr, 0, arr.length - 1));
    }

    private int last(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(first(arr, i + 1, j), first(arr, i, j - 1));
    }

    private int first(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + last(arr, i + 1, j), arr[j] + last(arr, i, j - 1));
    }


}
