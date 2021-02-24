package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.LinkedList;
import java.util.Stack;

public class Leetcode739 {
    public static void main(String[] args) {
        Leetcode739 obj = new Leetcode739();
        int[] arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = obj.dailyTemperatures(arr);
        System.out.println(res);
    }

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> queue = new Stack<>();
        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!queue.isEmpty() && T[queue.peek()] < T[i]) {
                int index = queue.pop();
                res[index] = i;
            }
            queue.push(i);
        }
        while (!queue.isEmpty()) {
            int index = queue.pop();
            res[index] = 0;
        }
        for(int i = 0;i< res.length;i++){
            if(res[i] != 0){
                res[i] = res[i] - i;
            }

        }
        return res;
    }
}
