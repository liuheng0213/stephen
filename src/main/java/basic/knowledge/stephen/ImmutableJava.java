package basic.knowledge.stephen;

import java.util.LinkedHashMap;

public class ImmutableJava {
    public static void main(String[] args) {
        final User user = new User();
        //user = new User();  no

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 2);
        map.put(1, 3);

        System.out.println(map.size());

        ImmutableJava immutableJava = new ImmutableJava();
        immutableJava.testAbstract();
    }

    private void testAbstract() {
        //Class1 class1 = new Class1();

    }

    static class User {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    abstract class Class1{
        String name;

        public Class1(String name) {
            this.name = name;
        }
    }
}
