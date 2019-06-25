package basic.knowledge.stephen.algorithm_4_Edition.ch1.entity;

import org.apache.tomcat.util.bcel.classfile.ClassFormatException;

public class User implements  Comparable{
    String name;
    Integer id;

    public User(String name) {
        this.name = name;
    }

    public User(Integer id) {
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User that = (User)o;
            return this.id - that.id;
        }
        throw new ClassFormatException("not User type");
    }
}
