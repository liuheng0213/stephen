package basic.knowledge.stephen.algorithm_4_Edition.ch3._05application;

import java.util.HashSet;
import java.util.Iterator;

public class E3_5_17MathSET<Key> {

    public static void main(String[] args) {
        E3_5_17MathSET<Integer> mathSET = new E3_5_17MathSET<Integer>(new Integer[]{1,3,5,7,9});
        mathSET.add(1);
        mathSET.add(7);
        mathSET.add(11);
        mathSET.add(13);
        mathSET.add(15);
        E3_5_17MathSET<Integer> complement = mathSET.complement();

        mathSET.union(complement);

        E3_5_17MathSET<Integer> newMathSET = new E3_5_17MathSET<Integer>();
        newMathSET.add(2);
        newMathSET.add(4);
        newMathSET.add(15);
        mathSET.intersection(newMathSET);
        System.out.println(mathSET.size());


    }

    private HashSet<Key> set = new HashSet<>();
    private Key[] universe;


    public E3_5_17MathSET(Key[] universe) {
        this.universe = universe;
    }

    public E3_5_17MathSET() {
    }

    public void add(Key key){
        this.set.add(key);
    }

    /**
     * set of keys in the universe that
       are not in this set
     求补集
     * @return
     */
    public E3_5_17MathSET<Key> complement(){
        E3_5_17MathSET<Key> nonExistant = new E3_5_17MathSET<>();
        for(Key key: universe){
            if(!this.set.contains(key)){
                nonExistant.add(key);
            }
        }
        return nonExistant;
    }

    /**
     * put any keys from a into the
       set that are not already there
     求并集
     * @param a
     */
    public void union(E3_5_17MathSET<Key> a){
        E3_5_17MathSET<Key> nonExistant = complement();
        Iterator<Key> iterator = nonExistant.set.iterator();
        while (iterator.hasNext()){
            Key current = iterator.next();
            this.add(current);
        }
    }

    /**
     * remove any keys from this set
       that are not in a

     求交集
     * @param a
     */
    public void intersection(E3_5_17MathSET<Key> a){
        Iterator<Key> iterator = this.set.iterator();
        while(iterator.hasNext()){
            Key current = iterator.next();
            if(!a.contains(current)){
                iterator.remove();
            }
        }
    }

    /**
     * remove key from the set
     * @param key
     */
    public void delete(Key key){
       this.set.remove(key);
    }

    public boolean contains(Key key) {
        return this.set.contains(key);
    }

    public boolean isEmpty(){
        return this.set.isEmpty();
    }

    public int size(){
        return this.set.size();
    }
}
