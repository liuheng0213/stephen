package basic.knowledge.stephen.jsonToObjectBean.person;

import java.io.Serializable;

public class Cat extends Pet implements Serializable{
    private static final long serialVersionUID = -5946106741405658960L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return "mammal";
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
