package basic.knowledge.stephen.jsonToObjectBean.person;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable{
    private static final long serialVersionUID = 3907067492809920355L;
    String name;
    Integer age;
    List<Pet> pets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pets=" + pets +
                '}';
    }
}
