package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany.StackAndQueue;

import java.util.Stack;

public class _05StackSort {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(11);
        stack.add(111);
        stack.add(1111);
        stack.add(11111);
        stack.add(111111);
        stack.add(1111111);

        sortStackByStrack(stack);

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    private static void sortStackByStrack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            int cur = stack.pop();
            while (!help.empty() && help.peek() < cur) {
                stack.push(help.pop());
            }

            help.push(cur);
        }

        while(!help.empty()){
            stack.push(help.pop());
        }
    }
}
