package basic.knowledge.stephen;

import java.util.HashSet;
import java.util.Set;

public class Final_Class {
    final String a = "";
    final Person person = new Person(18);
    final Set<String> stooges = new HashSet<>();

    public Final_Class(String a) {
        stooges.add("2");
    }

    public Final_Class(Person person) {
        this.person.setAge(19);
    }

    public Final_Class() {
    }

    public static void main(String[] args) {
        Final_Class final_class = new Final_Class();
        final_class.person.setAge(18); ;
        final_class.stooges.add("");

    }

    class Person{
        int age;

        public Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
