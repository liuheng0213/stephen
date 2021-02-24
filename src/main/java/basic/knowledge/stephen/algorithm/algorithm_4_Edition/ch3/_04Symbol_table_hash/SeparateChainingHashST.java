package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch3._04Symbol_table_hash;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch1.queue.MyQueue;
import basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch3._01Symbol_table_arr_linkList.SequentialSearchST;

import java.util.Iterator;

/**
 * 拉链法  ,独立链表法
 * N > M
 *
 * @param <Key>
 * @param <Value>
 */
public class SeparateChainingHashST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] sts;
    private int maxAvg;


    /**
     * 默认M = 997
     */
    public SeparateChainingHashST(int m) {
        this(m, 10);
    }

    public SeparateChainingHashST(int m, int maxAvg) {
        this.M = m;
        this.maxAvg = maxAvg;
        sts = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            sts[i] = new SequentialSearchST();
        }
    }

    public SeparateChainingHashST() {
        this(997, 10);
    }
    public int size(){
        return this.N;
    }

    //返回数组索引
    private int hash(Key key) {
        return (key.hashCode() & Integer.MAX_VALUE) % M;
    }

    public Value get(Key key) {
        return sts[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }

        if (value == null) {
            delete(key);
            return;
        }
        if (this.N / M >= maxAvg) {
            resize(2 * M);
        }

        int i = hash(key);
        if (!sts[i].contains(key)) {
            this.N++;
        }
        sts[hash(key)].put(key, value);
    }

    /**
     * e 3.4.18
     *
     * @param cap
     */
    private void resize(int cap) {
        SeparateChainingHashST<Key, Value> tempHashST = new SeparateChainingHashST<>(cap);
        for (int i = 0; i < this.M; i++) {
            Iterable<Key> keys = sts[i].keys();
            Iterator<Key> iterator = keys.iterator();
            while (iterator.hasNext()) {
                Key key = iterator.next();
                Value value = sts[i].get(key);
                tempHashST.put(key, value);
            }
        }
        this.sts = tempHashST.sts;
        this.M = tempHashST.M;
        this.N = tempHashST.N;
    }

    /**
     * 练习 3. 4. 19
     *
     * @return
     */
    public Iterable<Key> keys() {
        MyQueue<Key> queue = new MyQueue<>();
        for (SequentialSearchST st : sts) {
            Iterable<Key> keys = st.keys();
            Iterator<Key> iterator = keys.iterator();
            while (iterator.hasNext()) {
                queue.enqueue(iterator.next());
            }
        }
        return queue;
    }

    /**
     * @param key
     */
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        SequentialSearchST<Key, Value> st = sts[hash(key)];

        int i = hash(key);

        if (sts[i].contains(key)) {
            this.N--;
        }
        st.delete(key);
        if (this.M >= 997 && this.N / M < maxAvg / 4) {
            resize(M / 2);
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }
}

class AppSeparateChaining {
    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> hashST = new SeparateChainingHashST<String, Integer>();
        hashST.put("sss", 1);
        hashST.put("abc", 10);
        hashST.put("bgf", 111);
        hashST.put("tgfd", 12);
        hashST.put("eedsq", 21);
        hashST.put("opiu", 51);
        hashST.put("vbfg", 511);

        Integer integer = hashST.get("eedsq");
        System.out.println(integer);

//        Iterable<String> keys = hashST.keys();
//        Iterator<String> iterator = keys.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }


        hashST.delete("eedsq");

        Iterable<String> keys = hashST.keys();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
