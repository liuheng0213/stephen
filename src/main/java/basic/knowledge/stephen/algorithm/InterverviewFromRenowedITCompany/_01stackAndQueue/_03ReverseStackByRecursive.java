package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

/**
 * 仅用递归函数逆序一个栈
 */
public class _03ReverseStackByRecursive {
    public static void main(String[] args) {
        _03ReverseStackByRecursive obj = new _03ReverseStackByRecursive();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        obj.reverse(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int last = removeLast(stack);
        reverse(stack);
        stack.push(last);
    }

    private static int removeLast(Stack<Integer> stack) {
        int res = stack.pop();
        if(stack.isEmpty()){
            return res;
        }else{
            int last = removeLast(stack);
            stack.push(res);
            return last;
        }
    }
}
