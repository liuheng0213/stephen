package basic.knowledge.stephen.algorithm_4_Edition.ch3._04Symbol_table_hash;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import basic.knowledge.stephen.algorithm_4_Edition.ch3._01Symbol_table_arr_linkList.SequentialSearchST;

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
    private int maxAvgNum;


    /**
     * 默认M = 997
     */
    public SeparateChainingHashST(int maxAvgNum) {
        this(997, maxAvgNum);
    }

    public SeparateChainingHashST(int m, int maxAvgNum) {
        this.M = m;
        this.maxAvgNum = maxAvgNum;
        sts = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            sts[i] = new SequentialSearchST();
        }
    }

    public SeparateChainingHashST() {
        this(997, 2);
    }

    private int hash(Key key) {
        return (key.hashCode() & Integer.MAX_VALUE) % M;
    }

    public Value get(Key key) {
        return sts[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        if (this.N / M > maxAvgNum) {
            resize(2 * M);
        }
        int orgiStSize = sts[hash(key)].size();
        sts[hash(key)].put(key, value);
        if (sts[hash(key)].size() == orgiStSize + 1) {
            this.N++;
        }
    }

    private void resize(int num) {
        SequentialSearchST<Key, Value>[] newSts = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[num];
        System.arraycopy(sts, 0, newSts, 0, sts.length);
        this.sts = newSts;
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
        SequentialSearchST<Key, Value> st = sts[hash(key)];
        int oriSize = st.size();
        st.delete(key);
        if(st.size() == oriSize + 1){
            this.N--;
            if(this.N / M < maxAvgNum/4){
                resize(M/2);
            }
        }
    }
}

class App{
    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> hashST = new SeparateChainingHashST<String, Integer>();
        hashST.put("sss",1);
        hashST.put("abc",10);
        hashST.put("bgf",111);
        hashST.put("tgfd",12);
        hashST.put("eedsq",21);
        hashST.put("opiu",51);
        hashST.put("vbfg",511);

//        Iterable<String> keys = hashST.keys();
//        Iterator<String> iterator = keys.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }


        hashST.delete("eedsq");

        Iterable<String> keys = hashST.keys();
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
