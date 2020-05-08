package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 *
 * 有N堆石子排成一排，每堆石子有一定的数量。现要将N堆石子并成为一堆。合并的过程只能每次将相邻的两堆石子堆成一堆，
 * 每次合并花费的代价为这两堆石子的和，经过N-1次合并后成为一堆。求出总的代价最小值。
 *
 *
 * 只要每一次都合并两个最小的石子堆，那么最后得到的总代价必然最小。
 * (1)你有n堆石头质量分别为W1,W2,W3…Wn.(n＜＝100000)现在需要你将两堆石头合并，问一共所用力量最小是多少？
 */
public class StoneWeight {
    public static void main(String[] args) {
        int[] A = new int[]{13, 7 ,8 ,16, 21, 4, 18};
        int result = solution(A);
        System.out.println(result);
    }

    private static int solution(int[] A) {
        Arrays.sort(A);// very important
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
