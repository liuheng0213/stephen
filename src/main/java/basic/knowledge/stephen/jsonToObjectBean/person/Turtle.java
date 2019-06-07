package basic.knowledge.stephen.jsonToObjectBean.person;

import java.io.Serializable;

public class Turtle extends  Pet implements Serializable{

    private static final long serialVersionUID = -1730769349721688538L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return "reptile";
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Turtle{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
