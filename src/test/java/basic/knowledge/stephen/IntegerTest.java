package basic.knowledge.stephen;

import org.junit.Test;

/**
 * 两个都是非new出来的Integer，如果数在-128到127之间，则是true,否则为false。
 */
public class IntegerTest {
    @Test
    public void testEquals() {
        int int1 = 12;
        int int2 = 12;

        Integer integer1 = new Integer(12);
        Integer integer2 = new Integer(12);
        Integer integer3 = new Integer(127);

        Integer a1 = 127; //或者写成Integer a1 = Integer.valueOf(127);
        Integer a2 = 127;//或者写成Integer a2 = Integer.valueOf(127);

        Integer a = 128;
        Integer b = 128;

        System.out.println("int1 == int2 -> " + (int1 == int2));
        System.out.println("int1 == integer1 -> " + (int1 == integer1));
        System.out.println("integer1 == integer2 -> " + (integer1 == integer2));
        System.out.println("integer3 == a1 -> " + (integer3 == a1));
        System.out.println("a1 == a2 -> " + (a1 == a2));
        System.out.println("a == b -> " + (a == b));
    }
}
