package basic.knowledge.stephen.algorithm_4_Edition.entity;

public class User implements Comparable<User> {
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

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
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
    public int compareTo(User that) {
        return this.id - that.id;
    }
}
