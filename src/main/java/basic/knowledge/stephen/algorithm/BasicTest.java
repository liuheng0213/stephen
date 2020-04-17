package basic.knowledge.stephen.algorithm;

import java.util.LinkedList;

public class BasicTest {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
    }

    private static void test5() {
        System.out.println('c' - 'a');
    }

    private static void test4() {
        // TODO Auto-generated method stub
        String S = "012345678901234567890123456789";
        System.out.println(S.indexOf("23"));//输出2   （代表第一次出现字符串“23”的下标位置为2）
        System.out.println(S.indexOf("23", 4));//输出12  （代表从下标位置4开始，第一次出现字符串“23”的下标位置为12）

        System.out.println(S.lastIndexOf("89"));//输出30   （代表最后一次出现字符串“89”的下标位置为30）
        System.out.println(S.lastIndexOf("23", 11));//输出2  （代表从下标的位置0开始到下标的位置11结束最后一次出现字符串“23”的下标位置为2）
    }

    private static void test3() {
        String str = "11";
        char[] chars = str.toCharArray();
        System.out.println((chars[0] - '0') * 10 + (chars[1] - '0'));
    }

    private static void test2() {
        String str = "23456";
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            System.out.println("1 =====> " + ch);
            System.out.println("2 =====> " + Integer.valueOf(ch));
            System.out.println("3 =====> " + ch + "");
        }
        System.out.println();
    }

    private static void test1() {
       /* String str = "123";
        System.out.println(str.substring(0, 3));

        str = "1+2+3";
        String[] split = str.split("\\+");
        System.out.println(Arrays.toString(split));
*/
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        //System.out.println(queue.peek());
        System.out.println(queue.pollFirst());//删队列头
        System.out.println(queue.poll());//删队列头

        System.out.println("size :" + queue.size());

        System.out.println(queue.peek());//看队列头
        System.out.println(queue.pop());//删队列头
        System.out.println("size :" + queue.size());
        System.out.println(queue.getLast());//看队列尾
        System.out.println("size :" + queue.size());
        System.out.println(queue.pollLast());//删队列尾

        System.out.println("size :" + queue.size());

    }
}
