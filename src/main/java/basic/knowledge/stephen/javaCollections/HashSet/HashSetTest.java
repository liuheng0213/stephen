package basic.knowledge.stephen.javaCollections.HashSet;

import basic.knowledge.stephen.javaCollections.entity.Person;

import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {

        HashSet<Person> set = new HashSet<>();

        set.add(new Person("1",24));
        set.add(new Person("2",56));
        set.add(new Person("2",56));
        set.add(new Person("1",24));

        for (Person p:
                set ) {
            System.out.println(p.toString());
        }
    }
}
