package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany.StackAndQueue;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 */
public class _01MyStackWithGetMin {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;


    public _01MyStackWithGetMin() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum){
        if(this.stackMin.empty()){
            this.stackMin.push(newNum);
        }else if(this.stackMin.peek() >= newNum){
            this.stackMin.push(newNum);
        }

        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.empty()){
            throw new RuntimeException("stack is empty!");
        }

        Integer value = this.stackData.pop();
        if(this.getMin() == value){
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if(this.stackMin.empty()){
            throw new RuntimeException("stack is empty!");
        }
        return this.stackMin.peek();
    }
}
