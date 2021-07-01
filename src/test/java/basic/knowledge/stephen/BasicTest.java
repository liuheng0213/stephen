package basic.knowledge.stephen;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class BasicTest {
    @Test
    public void testTreeSet() {
        String str = "abc123";
        String substring = str.substring(3,5);

        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        System.out.println();
        if (set != null) {
            Iterator<Integer> iterator = set.iterator();
            while(iterator.hasNext()){
                Integer next = iterator.next();
                if(set.higher(next) != null){
                    iterator.remove();
                }
            }

            System.out.println();
        }

    }

    @Test
    public void testMapC() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        String v = map.computeIfAbsent("b", k -> "v");  // 输出 B
        System.out.println(v);
        String v1 = map.computeIfAbsent("c", k -> "v"); // 输出 v
        System.out.println(v1);
    }

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        String v = map.putIfAbsent("b", "v");  // 输出 B
        System.out.println(v);
        String v1 = map.putIfAbsent("c", "v");  // 输出 null
        System.out.println(v1);
    }

    class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
