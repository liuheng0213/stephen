package basic.knowledge.stephen.algorithms.ch1_queue_statck.stack;


import org.junit.Test;

import java.util.Iterator;

public class StackTest {
    @Test
    public void testArrayStack(){
        MyResizingArrayStack<User> stack = new MyResizingArrayStack<>();
        stack.push(new User("1"));
        stack.push(new User("2"));
        stack.push(new User("3"));
        stack.push(new User("4"));

        Iterator<User> iterator = stack.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            System.out.println(user);
        }
        User pop = stack.pop();
        System.out.println(pop);
        System.out.println("-------------");
        Iterator<User> iterator2 = stack.iterator();
        while(iterator2.hasNext()){
            User user = iterator2.next();
            System.out.println(user);
        }

        System.out.println(stack.size());

    }

    @Test
    public void testLinkStack(){
        MyLinkStack<User> stack = new MyLinkStack<>();
        stack.push(new User("1"));
        stack.push(new User("2"));
        stack.push(new User("3"));
        stack.push(new User("4"));
        stack.push(new User("5"));

        Iterator<User> iterator = stack.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            System.out.println(user);
        }
        User pop = stack.pop();
        System.out.println(pop);
        System.out.println("-------------");
        Iterator<User> iterator2 = stack.iterator();
        while(iterator2.hasNext()){
            User user = iterator2.next();
            System.out.println(user);
        }

        System.out.println(stack.size());
    }
}
