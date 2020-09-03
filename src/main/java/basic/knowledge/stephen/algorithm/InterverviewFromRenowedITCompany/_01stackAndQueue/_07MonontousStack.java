package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

public class _07MonontousStack {

    public static void main(String[] args) {
        _07MonontousStack obj = new _07MonontousStack();
        int[] arr = new int[]{3, 4, 1, 5, 6, 2, 7};
        int[][] res = obj.getNearestLessNoRepetitive(arr);
        System.out.println();
    }

    public int[][] getNearestLessNoRepetitive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int[][] res = new int[arr.length][2];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int index = stack.pop();
                res[index][1] = i;
                res[index][0] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            res[index][1] = -1;
            res[index][0] = stack.isEmpty() ? -1 : stack.peek();
        }

        return res;
    }
}
