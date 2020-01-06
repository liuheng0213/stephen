package basic.knowledge.stephen.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class BasicTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
       /* String str = "123";
        System.out.println(str.substring(0, 3));

        str = "1+2+3";
        String[] split = str.split("\\+");
        System.out.println(Arrays.toString(split));
*/
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(11);
        queue.add(111);
        queue.add(1111);
        queue.add(11111);
        queue.add(111111);

        //System.out.println(queue.peek());
        System.out.println(queue.pollFirst());
        System.out.println(queue.poll());

    }
}
