package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _08MonontousStackFurther {
    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 3, 5, 3, 2, 2};
        _08MonontousStackFurther obj = new _08MonontousStackFurther();
        int[][] res = obj.getNearestLessNoRepetitive(arr);
        System.out.println();
    }

    public int[][] getNearestLessNoRepetitive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int[][] res = new int[arr.length][2];

        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> pops = stack.pop();

                for (Integer popi : pops) {
                    res[popi][1] = i;
                    res[popi][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                }
            }

            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                stack.push(arrayList);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> pops = stack.pop();
            for (Integer popi : pops) {
                res[popi][1] = -1;
                res[popi][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            }
        }


        return res;
    }
}
