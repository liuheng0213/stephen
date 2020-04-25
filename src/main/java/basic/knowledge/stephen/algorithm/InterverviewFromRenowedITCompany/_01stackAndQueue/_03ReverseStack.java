package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

/**
 * 递归逆序一个栈
 */
public class _03ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);

        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.empty()){
            return;
        }

        int i = getAndRemoveLastEle(stack);
        reverse(stack);
        stack.push(i);
    }

    private static int getAndRemoveLastEle(Stack<Integer> stack) {
        int result = stack.pop();
        if(stack.empty()){
            return result;
        }

        int last = getAndRemoveLastEle(stack);
        stack.push(result);
        return last;
    }
}
