package basic.knowledge.stephen.algorithm_4_Edition.ch3._04Symbol_table_hash;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import basic.knowledge.stephen.algorithm_4_Edition.ch3._01Symbol_table_arr_linkList.SequentialSearchST;

import java.util.Iterator;

public class SeparateChainingHashST<Key extends Comparable<Key>, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key,Value>[] sts;


    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int m) {
        M = m;
        sts = new SequentialSearchST[m];
        for(int i = 0;i<m;i++){
            sts[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key){
        return (key.hashCode() & Integer.MAX_VALUE) % M;
    }

    public Value get(Key key){
        return sts[hash(key)].get(key);
    }

    public void put(Key key,Value value){
        sts[hash(key)].put(key,value);
    }

    public Iterable<Key> keys(){
        MyQueue<Key> queue = new MyQueue<>();
        for(SequentialSearchST st : sts){
            Iterable keys = st.keys();
            Iterator iterator = keys.iterator();
            while(iterator.hasNext()){
                queue.enqueue((Key) iterator.next());
            }
        }

        return queue;
    }
}
