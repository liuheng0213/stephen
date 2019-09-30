package basic.knowledge.stephen;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class JDKTest {
    @Test
    public void testStr() {
        String regex = "^\\d{1,4}+(\\.\\d{0,2})?$";
        boolean matches = "0".matches(regex);
        System.out.println(matches);
    }

    @Test
    public void testRegex() {
        String regex = "[\\:.]";
        String str = "1:9.3.4:345:126";
        String[] split = str.split(regex);
        System.out.println(Arrays.toString(split));
    }

    @Test
    public void testToArray() {
        List<String> strList = new ArrayList<>();
        strList.add("111");
        strList.add("111");
        strList.add("111");
        strList.add("111");
        strList.add("111");
        System.out.println(strList);
    }

    @Test
    public void testSet2Array() {
        HashSet<Object> s1 = new HashSet<>();
        s1.add("1");
        s1.add("2");
        s1.add("3");
        ArrayList<Object> l1 = new ArrayList(s1);
        System.out.println(l1);

    }

    @Test
    public void test() {
        int i = 4 / 5;
        System.out.println(i);

        int j = 4;
        int k = 5;

        double d1 = j;
        double d2 = k;

        System.out.println(d1 / d2);
    }

    @Test
    public void testIntDouble() {
        int i = 2;
        int j = 5;

        double k = j;
        System.out.println(i / k);
    }

}
