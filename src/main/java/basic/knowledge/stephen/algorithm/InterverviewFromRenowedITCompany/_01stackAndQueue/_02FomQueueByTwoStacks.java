package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

/**
 * 用两个队列构成一个栈 且有如下API
 * add poll peek
 */
public class _02FomQueueByTwoStacks {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public _02FomQueueByTwoStacks() {
        this.stackPop = new Stack<>();
        this.stackPush = new Stack<>();
    }

    public void add(Integer newNum) {
        this.stackPush.push(newNum);
        pushToPop();
    }

    private void pushToPop() {
        if (this.stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }
    }

    public Integer poll() {
        if (this.stackPop.isEmpty() && this.stackPush.isEmpty()) {
            throw new RuntimeException();
        }
        pushToPop();
        return this.stackPop.pop();
    }

    public Integer peek() {
        if (this.stackPop.isEmpty() && this.stackPush.isEmpty()) {
            throw new RuntimeException();
        }
        pushToPop();
        return this.stackPop.peek();
    }
}
