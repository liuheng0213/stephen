package basic.knowledge.stephen.algorithm_4_Edition.leetcode.greedy;

import java.util.Arrays;

/**
 * (1)你有n堆石头质量分别为W1,W2,W3…Wn.(n＜＝100000)现在需要你将两堆石头合并，问一共所用力量最小是多少？
 */
public class StoneWeight {
    public static void main(String[] args) {
        int[] A = new int[]{3, 1, 7, 5};
        int result = solution(A);
        System.out.println(result);
    }

    private static int solution(int[] A) {
        Arrays.sort(A);
        int tempSum = 0;
        int sum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            tempSum = A[i] + A[i + 1];
            A[i] = 0;
            A[i + 1] = tempSum;
            sum += tempSum;
            Arrays.sort(A);
        }

        return sum;
    }
}
