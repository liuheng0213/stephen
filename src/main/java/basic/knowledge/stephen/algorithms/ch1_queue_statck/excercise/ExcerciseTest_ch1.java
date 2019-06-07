package basic.knowledge.stephen.algorithms.ch1_queue_statck.excercise;

import basic.knowledge.stephen.algorithms.ch1_queue_statck.stack.MyLinkListStack;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class ExcerciseTest_ch1<T> {
  @Test
  public void test1_3_27(){
      MyLinkListStack<Integer> stack = new MyLinkListStack<>();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(5);
      stack.push(7);
      stack.push(9);
      stack.push(2);
      stack.push(-1);
      stack.push(1);
      stack.push(11);
      stack.push(0);
      stack.push(2);

      Integer max = stack.max(stack.getFirst());
      System.out.println(max);
  }

    @Test
    public void test1_3_28(){
        MyLinkListStack<Integer> stack = new MyLinkListStack<>();
        stack.push(65);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(2);
        stack.push(-1);
        stack.push(1);
        stack.push(11);
        stack.push(0);
        stack.push(55);

        Integer max = stack.maxByRecursive(stack.getFirst());
        System.out.println(max);
    }

    @Test
    public void test1_3_30(){
        MyLinkListStack<Integer> stack = new MyLinkListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(2);
        stack.push(-1);
        stack.push(1);
        stack.push(11);
        stack.push(0);
        stack.push(2);

        MyLinkListStack<Integer>.Node reverseFirstNode = stack.getReverseFirstNode(stack.getFirst());
        System.out.println(reverseFirstNode.getT());
        System.out.println("=====================");

        Iterator<Integer> iterator = stack.iterator();
        while(iterator.hasNext()){
            Integer num = iterator.next();
            System.out.println(num);
        }
    }


    @Test
    public void test1_3_30_recursion(){
        MyLinkListStack<Integer> stack = new MyLinkListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(7);


        MyLinkListStack<Integer>.Node reverseFirstNode = stack.getReverseFirstNodeByRecursion(stack.getFirst());
        System.out.println(reverseFirstNode.getT());
        System.out.println("=====================");

        Iterator<Integer> iterator = stack.iterator();
        while(iterator.hasNext()){
            Integer num = iterator.next();
            System.out.println(num);
        }
    }

}
