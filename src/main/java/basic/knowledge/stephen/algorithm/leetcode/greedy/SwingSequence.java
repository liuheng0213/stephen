package basic.knowledge.stephen.algorithm.leetcode.greedy;


/**
 * 摇摆序列
 * 当序列有一段连续的递增(或递减)时，为形成摇摆子序列，我们只需要保留这段连续的递增(或递减)的首尾元素，
 * 这样更有可能使得尾部的后一个元素成为摇摆子序列的下一个元素。
 */
public class SwingSequence {
    public static void main(String[] args) {
        int[] A = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int result = solution(A);
        System.out.println(result);
    }

    private static int solution(int[] A) {
        int BEGIN = 0;
        int UP = 1;
        int DOWN = 2;

        int maxLength = 1;
        int status = BEGIN;
        for (int i = 1; i < A.length; i++) {
            if (status == BEGIN) {
                if (A[i - 1] < A[i]) {
                    status = UP;
                    maxLength++;
                } else if (A[i - 1] > A[i]) {
                    status = DOWN;
                    maxLength++;
                }
            } else if (status == UP) {
                if (A[i - 1] > A[i]) {
                    status = DOWN;
                    maxLength++;
                }
            } else if (status == DOWN) {
                if (A[i - 1] < A[i]) {
                    status = UP;
                    maxLength++;
                }
            }
        }

        return maxLength;
    }
}
