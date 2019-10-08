package basic.knowledge.stephen.algorithm_4_Edition.ch3._05application;


import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.Iterator;

public class E3_5_1HashSET<Key> {

    private SeparateChainingHashST st;


    public E3_5_1HashSET() {
        st = new SeparateChainingHashST();
    }

    public void add(Key key){
        this.st.put(key,"");
    }

    public void delete(Key key){
        this.st.delete(key);
    }

    public boolean contains(Key key){
        return st.contains(key);
    }

    public boolean isEmpty(){
        return st.isEmpty();
    }

    public int size(){
        return st.size();
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        Iterable<Key> keys = st.keys();
        Iterator<Key> iterator = keys.iterator();
        while(iterator.hasNext()){
            Key next = iterator.next();
            str.append(next).append("\n");
        }

        return str.toString();
    }


}

class APP{

    public static void main(String[] args) {
        E3_5_1HashSET<Integer> hashSET = new E3_5_1HashSET<>();

        hashSET.add(1);
        hashSET.add(4);
        hashSET.add(1);
        hashSET.add(5);
        hashSET.add(12);
        hashSET.add(111);
        hashSET.add(21);
        hashSET.add(145);
        hashSET.add(131);
        hashSET.add(61);
        hashSET.add(91);

        String s = hashSET.toString();
        System.out.println(s);
        System.out.println("-----------------");
        System.out.println(hashSET.size());
    }
}