package basic.knowledge.stephen.algorithm;

import java.util.Arrays;

public class BasicTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        String str = "123";
        System.out.println(str.substring(0,3));

        str = "1+2+3";
        String[] split = str.split("\\+");
        System.out.println(Arrays.toString(split));
    }
}
