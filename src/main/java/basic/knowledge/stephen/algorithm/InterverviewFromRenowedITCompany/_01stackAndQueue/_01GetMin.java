package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

/**
 * 用栈完成getMin方法 且O(1)
 */
public class _01GetMin {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;


    public _01GetMin() {
        this.minStack = new Stack<>();
        this.stack = new Stack<>();
    }


    public void push(Integer value) {
        this.stack.push(value);
        if (minStack.isEmpty() || this.getMin() >= value) {
            this.minStack.push(value);
        }
    }

    public Integer getMin() {
        if (this.minStack.isEmpty()) {
            throw new RuntimeException("");
        }
        return this.minStack.peek();
    }

    public Integer pop() {
        if (this.stack.isEmpty()) {
            throw new RuntimeException("");
        }
        if (!minStack.isEmpty() && this.getMin() == this.stack.peek()) {
            this.minStack.pop();
        }
        return this.stack.pop();
    }
}
