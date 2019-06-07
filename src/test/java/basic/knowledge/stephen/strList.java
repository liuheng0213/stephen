package basic.knowledge.stephen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class strList {
    @Test
    public void testStr(){
        String regex = "^\\d{1,4}+(\\.\\d{0,2})?$";
        boolean matches = "0".matches(regex);
        System.out.println(matches);
    }

    @Test
    public void testToArray(){
        List<String> strList = new ArrayList<>();
        strList.add("111");
        strList.add("111");
        strList.add("111");
        strList.add("111");
        strList.add("111");
        System.out.println(strList);
    }

    @Test
    public void testSet2Array(){
        HashSet<Object> s1 = new HashSet<>();
        s1.add("1");
        s1.add("2");
        s1.add("3");
        ArrayList<Object> l1 = new ArrayList(s1);
        System.out.println(l1);

    }

    @Test
    public void test(){
        int i = 4/5;
        System.out.println(i);
    }

}
