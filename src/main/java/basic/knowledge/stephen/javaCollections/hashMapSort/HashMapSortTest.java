package basic.knowledge.stephen.javaCollections.hashMapSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HashMapSortTest {

    public static void main(String[] args) {
        Map<Integer,User> originalUsers = new HashMap<>();
        originalUsers.put(1, new User("ssm",22));
        originalUsers.put(2, new User("xyz",32));
        originalUsers.put(5, new User("ssm",15));

        System.out.println(originalUsers);
        HashMap<Integer,User> sortedUsers = sortUsers(originalUsers);
        System.out.println(sortedUsers);
    }

    private static HashMap<Integer,User> sortUsers(Map<Integer, User> originalUsers) {
        //get entry
        Set<Map.Entry<Integer, User>> entries = originalUsers.entrySet();

        //set is converted to  a  list in order to sort entry conveniently
        ArrayList<Map.Entry<Integer, User>> entryList = new ArrayList<>(entries);
        //sorting
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, User>>() {

            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                User u1 = o1.getValue();        //get one value in the entry
                User u2 = o2.getValue();
                return u1.getAge()-u2.getAge();
            }
        });
        //linkedHashMap can ensure the sequence in which data was put into the map
        LinkedHashMap<Integer,User> sortedUsers = new LinkedHashMap<>();
        //i use iterator to iterate the entryList
        Iterator<Map.Entry<Integer, User>> iterator = entryList.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, User> currentEntry = iterator.next();
            sortedUsers.put(currentEntry.getKey(), currentEntry.getValue());
        }
        return sortedUsers;
    }
}
