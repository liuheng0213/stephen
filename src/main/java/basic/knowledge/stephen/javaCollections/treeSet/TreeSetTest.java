package basic.knowledge.stephen.javaCollections.treeSet;

import java.util.Collection;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        stringBuilder.append(2);
        stringBuilder.substring(1);
        stringBuilder.delete(0,1);



        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(6);
        treeSet.add(9);
        treeSet.add(12);
        treeSet.add(13);
        treeSet.add(23);
        treeSet.add(31);
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(-1);
        treeSet.add(39);


        SortedSet<Integer> integers = treeSet.tailSet(23);
        SortedSet<Integer> integers1 = treeSet.headSet(23);

        Integer first = treeSet.first();

        Integer lower = treeSet.lower(12);
        Integer ceiling = treeSet.ceiling(5);

        Integer integer = treeSet.pollLast();

        
        
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(1,3);
        treeMap.put(13,39);
        treeMap.put(31,31);
        treeMap.put(21,23);
        treeMap.put(22,13);
        treeMap.put(12,3);
        treeMap.put(41,34);
        treeMap.put(16,3333);
        treeMap.put(19,335);

        Integer integer4 = treeMap.firstKey();
        Integer integer1 = treeMap.lastKey();
        Integer integer2 = treeMap.lowerKey(13);
        Integer integer3 = treeMap.higherKey(16);
        SortedMap<Integer, Integer> integerIntegerSortedMap = treeMap.headMap(22);

        Collection<Integer> values = treeMap.values();
        values.toArray();
        System.out.println();


        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(2);
        linkedList.addLast(12);
        linkedList.addLast(22);
        linkedList.addLast(32);

        System.out.println();
    }
}
