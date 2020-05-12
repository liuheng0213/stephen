package basic.knowledge.stephen.algorithm.leetcode.doublePoints;

import java.util.Arrays;

public class Leetcode667 {
    public static void main(String[] args) {
        Leetcode667 leetcode667 = new Leetcode667();
        int[] res = leetcode667.constructArray(6, 5);
        System.out.println(Arrays.toString(res));
    }

    private int[] constructArray(int n, int k) {
        int i = 1;
        int j = n;
        int[] res = new int[n];
        int index = 0;
        while (i <= j) {
            if (k > 1) {
                res[index++] = (k-- % 2 > 0 ? i++ : j--);
            } else {
                res[index++] = i++;
            }
        }
        return res;
    }
}
