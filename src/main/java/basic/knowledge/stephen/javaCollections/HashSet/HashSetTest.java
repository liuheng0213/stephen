package basic.knowledge.stephen.javaCollections.HashSet;

import basic.knowledge.stephen.javaCollections.entity.Person;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {

        HashSet<Person> set = new HashSet<>();

        set.add(new Person("1",24));
        set.add(new Person("2",56));
        set.add(new Person("2",56));

        set.add(new Person("1",24));
        HashSet<Person> se2 = new HashSet<>();
        se2.add(new Person("3",56));
        se2.add(new Person("1",24));
        boolean b = set.containsAll(se2);


        HashSet<Integer> intSet = new HashSet<>();
        boolean add = intSet.add(1);
        boolean add2 = intSet.add(1);
        System.out.println();
        for (Person p:
                set ) {
            System.out.println(p.toString());
        }
    }
}
