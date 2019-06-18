package basic.knowledge.stephen.algorithms.ch1_queue_statck.app;

import basic.knowledge.stephen.algorithms.ch1_queue_statck.stack.MyLinkStack;
import org.junit.Test;

import java.util.Iterator;

public class ExcerciseTest_ch1<T> {
  @Test
  public void test1_3_27(){
      MyLinkStack<Integer> stack = new MyLinkStack<>();
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
        MyLinkStack<Integer> stack = new MyLinkStack<>();
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
        MyLinkStack<Integer> stack = new MyLinkStack<>();
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

        MyLinkStack<Integer>.Node reverseFirstNode = stack.getReverseFirstNode(stack.getFirst());
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
        MyLinkStack<Integer> stack = new MyLinkStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(7);


        MyLinkStack<Integer>.Node reverseFirstNode = stack.getReverseFirstNodeByRecursion(stack.getFirst());
        System.out.println(reverseFirstNode.getT());
        System.out.println("=====================");

        Iterator<Integer> iterator = stack.iterator();
        while(iterator.hasNext()){
            Integer num = iterator.next();
            System.out.println(num);
        }
    }

}
