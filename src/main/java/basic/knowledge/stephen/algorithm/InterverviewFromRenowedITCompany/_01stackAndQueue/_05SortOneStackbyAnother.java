package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 */
public class _05SortOneStackbyAnother {
    public static void main(String[] args) {
        _05SortOneStackbyAnother obj = new _05SortOneStackbyAnother();
        Stack<Integer> stack = new Stack<>();
        stack.push(16);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        obj.sortDSC(stack);
        System.out.println();
    }

    public void sortDSC(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Stack<Integer> help = new Stack<>();
        int ele;
        while (!stack.isEmpty()) {
            ele = stack.pop();
            while (!help.isEmpty() && help.peek() < ele) {
                stack.push(help.pop());
            }
            help.push(ele);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }

    }
}
