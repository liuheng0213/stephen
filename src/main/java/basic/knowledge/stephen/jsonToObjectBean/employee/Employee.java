package basic.knowledge.stephen.jsonToObjectBean.employee;

import basic.knowledge.stephen.jsonToObjectBean.serializer.DateTimeDeserializerInJackson;
import basic.knowledge.stephen.jsonToObjectBean.serializer.DateTimeSerializerInGson;
import basic.knowledge.stephen.jsonToObjectBean.serializer.DateTimeSerializerInJackson;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.JsonAdapter;
import org.joda.time.DateTime;

import java.io.Serializable;

public class Employee implements Serializable{
    private static final long serialVersionUID = -6986227003856719618L;
    String name;
    RegistryDate registryDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegistryDate getRegistryDate() {

        return registryDate;
    }

    public void setRegistryDate(RegistryDate registryDate) {
        this.registryDate = registryDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", registryDate=" + registryDate +
                '}';
    }


    public static class RegistryDate{

        @JsonAdapter(DateTimeSerializerInGson.class)        //for  gson
        DateTime startDate;

        public DateTime getStartDate() {
            return startDate;
        }

        @JsonDeserialize(using= DateTimeDeserializerInJackson.class)  //got jackson
        @JsonSerialize(using= DateTimeSerializerInJackson.class)
        public void setStartDate(DateTime startDate) {
            this.startDate = startDate;
        }

        @Override
        public String toString() {
            return "RegistryDate{" +
                    "startDate=" + startDate +
                    '}';
        }
    }
}
