package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch3._05application;


import basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch3._03Symbol_table_bTree.BinarySearchST_RedBlackTree;
import edu.princeton.cs.algs4.RedBlackBST;

import java.util.Iterator;

public class E3_5_01SET<Key extends Comparable<Key>> {
    private BinarySearchST_RedBlackTree<Key,String> st;


    public E3_5_01SET() {
        st = new BinarySearchST_RedBlackTree();
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
