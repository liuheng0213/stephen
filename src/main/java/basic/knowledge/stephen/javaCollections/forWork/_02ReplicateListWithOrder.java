package basic.knowledge.stephen.javaCollections.forWork;

import java.util.*;

/**
 * 给list中的元素的某一个字段排序,且保持顺序
 */
public class _02ReplicateListWithOrder {
    public static void main(String[] args) {
        Person a = new Person(1, "a");
        Person b = new Person(2, "b");
        Person c = new Person(3, "c");
        Person d = new Person(null, "d");
        Person e = new Person(null, "e");
        Person f = new Person(null, "f");
        Person g = new Person(1, "g");
        Person h = new Person(1, "h");
        Person i = new Person(4, "i");

        List<Person> pList = new ArrayList<>();
        pList.add(a);
        pList.add(b);
        pList.add(c);
        pList.add(d);
        pList.add(e);
        pList.add(f);
        pList.add(g);
        pList.add(h);
        pList.add(i);
        for (Person p:
            pList ) {
            System.out.println(p);
        }
        List<Person> result = removeDuplicateWithOrder(pList);
        System.out.println("=========================================================="+(null==null));
        for (Person p:
                result ) {
            System.out.println(p);
        }
    }

    private static List<Person> removeDuplicateWithOrder(List<Person> pList) {
        for  ( int  i  =   0 ; i  <  pList.size()  -   1 ; i ++ )  {
            for  ( int  j  =  pList.size()  -   1 ; j  >  i; j -- )  {
                if  (pList.get(j).getId()!=null && pList.get(j).equals(pList.get(i)))  {        //注意这里一定要改person的equals, 只比对groupId
                    pList.remove(j);
                }
            }
        }
        return pList;
    }
}

class Person {
    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
