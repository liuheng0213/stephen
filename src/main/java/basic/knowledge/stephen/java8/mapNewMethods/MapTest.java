package basic.knowledge.stephen.java8.mapNewMethods;

import java.util.HashMap;

public class MapTest {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        //putIfAbsent  donot override original value
        String haha = map.putIfAbsent(1, "haha1");
        String haha2 = map.putIfAbsent(2, "haha2");
        String haha3 = map.putIfAbsent(1, "haha11");
        String haha4= map.putIfAbsent(3, "haha13");


        String dd = map.getOrDefault(1, "dd");//haha1
        String dd1 = map.getOrDefault(4, "dd");//dd

        System.out.println();
        
    }
}
