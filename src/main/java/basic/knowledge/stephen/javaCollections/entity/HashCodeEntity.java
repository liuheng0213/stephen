package basic.knowledge.stephen.javaCollections.entity;

import java.util.Objects;

public class HashCodeEntity {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashCodeEntity)) return false;
        HashCodeEntity that = (HashCodeEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
