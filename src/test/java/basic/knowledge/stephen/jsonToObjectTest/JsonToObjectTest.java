package basic.knowledge.stephen.jsonToObjectTest;

import basic.knowledge.stephen.jsonToObjectBean.employee.Employee;
import basic.knowledge.stephen.jsonToObjectBean.person.Cat;
import basic.knowledge.stephen.jsonToObjectBean.person.Person;
import basic.knowledge.stephen.jsonToObjectBean.person.Pet;
import basic.knowledge.stephen.jsonToObjectBean.person.Turtle;
import basic.knowledge.stephen.jsonToObjectBean.serializer.DateTimeSerializerInGson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//  https://blog.csdn.net/sunrainamazing/article/details/80989711
public class JsonToObjectTest {
    private static final Gson gson = new Gson();

    @Test
    public void datetime(){
        DateTime dateTime = DateTime.now();
        String str = dateTime.toString(DateTimeSerializerInGson.DATETIME_PATTERN);
        System.out.println(str);
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DateTimeSerializerInGson.DATETIME_PATTERN);
        DateTime dateTime1 = dateTimeFormatter.parseDateTime(str);
        System.out.println(dateTime1);
    }
    @Test
    public void testJsonToObject() {
        Pet petCat1 = new Cat();
        petCat1.setName("i am the first cat");

        Pet petCa2t = new Cat();
        petCa2t.setName("i am the second cat");

        Pet petTurtle = new Turtle();
        petTurtle.setName("i am the first turtle");

        List<Pet> petList = new ArrayList<>();
        petList.add(petCat1);
        petList.add(petTurtle);

        Person person = new Person();
        person.setAge(1);
        person.setName("hengheng");
        person.setPets(petList);

        String json = gson.toJson(person);
        System.out.println(json);


    }

    @Test
    public void Obejct2Json() {
        Person person = gson.fromJson("{\n" +
                "  \"name\": \"hengheng\",\n" +
                "  \"age\": 1,\n" +
                "  \"pets\": [\n" +
                "    {\n" +
                "      \"name\": \"i am the first cat\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"i am the first turtle\"\n" +
                "    }\n" +
                "  ]\n" +
                "}", Person.class);
        System.out.println(person);// report error ,so while developping , it's supposed to avoid this data structure
    }

    @Test
    public void employee2Json() throws JsonProcessingException {
        Employee.RegistryDate registryDate = new Employee.RegistryDate();
        registryDate.setStartDate(new DateTime(new Date()));

        Employee employee = new Employee();
        employee.setRegistryDate(registryDate);
        employee.setName("hengheng");

        /*String json = gson.toJson(employee);*/
        String json = new ObjectMapper().writeValueAsString(employee);
        System.out.println(json);
    }

    @Test
    public void json2Employee() throws IOException {

        String json = "{\n" +
                "  \"name\": \"hengheng\",\n" +
                "  \"registryDate\": {\n" +
                "    \"startDate\": \"20-04-2019 16:41:56\"\n" +
                "  }\n" +
                "}";

        /*Employee employee = gson.fromJson(json, Employee.class);*/
        Employee employee = new ObjectMapper().readValue(json, Employee.class);
        System.out.println(employee);
    }



}

//  https://blog.csdn.net/sunrainamazing/article/details/80989711
