package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01StackAndQueue;

import java.util.Stack;

public class _02TwoStacksFormingQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;


    public _02TwoStacksFormingQueue() {
        this.stackPop = new Stack<>();
        this.stackPush = new Stack<>();
    }

    private void pushToPop(){
        if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int newNum){
        stackPush.push(newNum);
        pushToPop();
    }

    public int poll(){
        if(stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("ggggggggggggg");
        }
        pushToPop();
        return this.stackPop.pop();
    }

    public int peek(){
        if(stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("ggggggggggggg");
        }
        pushToPop();
        return this.stackPop.peek();
    }
}
