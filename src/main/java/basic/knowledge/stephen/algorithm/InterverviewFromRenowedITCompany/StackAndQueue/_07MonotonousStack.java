package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany.StackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 典型的单调栈应用
 * 带重复元素
 */
public class _07MonotonousStack {

    public static void main(String[] args) {
        _07MonotonousStack monotonousStack = new _07MonotonousStack();
        int[] arr = new int[]{3, 1, 3, 4, 3, 5, 3, 2, 2};
        int[][] res = monotonousStack.getNearLess(arr);

        for(int i = 0;i<res.length;i++){
            for(int j = 0;j < res[0].length;j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while(!stack.empty() && arr[stack.peek().get(0)] > arr[i] ){
                List<Integer> indexes = stack.pop();
                int leftIndex = stack.isEmpty()? -1: stack.peek().get(stack.peek().size() - 1);

                for (Integer index: indexes) {
                    res[index][0] = leftIndex;
                    res[index][1] = i;
                }
            }

            if(!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]){
                stack.peek().add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }


        }
        //清算
        while(!stack.isEmpty()){
            List<Integer> indexes = stack.pop();
            int leftIndex = stack.isEmpty()? -1: stack.peek().get(stack.peek().size() - 1);
            for (Integer index: indexes) {
                res[index][0] = leftIndex;
                res[index][1] = -1;
            }
        }

        return  res;
    }
}
