package basic.knowledge.stephen.javaCollections.HashRelevant;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 5);
        map.put(1, 6);
        map.put(2, 7);
        map.put(2, 8);
        System.out.println(map);
    }
}
