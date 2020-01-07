package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany.StackAndQueue;

import java.util.Stack;

public class _07MonotonousStack {
    public static void main(String[] args) {
        _07MonotonousStack monotonousStack = new _07MonotonousStack();
        int[] arr = new int[]{3, 4, 1, 5, 6, 2, 7};
        int[] arr1 = new int[]{3, 1, 3, 4, 3, 5, 3, 2, 2};
        int[][] res = monotonousStack.getNearLess(arr1);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[][] getNearLess(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        //清算
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            res[popIndex][0] = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][1] = -1;
        }
        return res;
    }
}
