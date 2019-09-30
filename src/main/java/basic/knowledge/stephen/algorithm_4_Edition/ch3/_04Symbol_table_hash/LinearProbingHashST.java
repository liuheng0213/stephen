package basic.knowledge.stephen.algorithm_4_Edition.ch3._04Symbol_table_hash;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 开放地址的线性探索法
 * <p>
 * m>n
 * 要保证m 是 n的四倍
 *
 * @param <Key>
 * @param <Value>
 */
public class LinearProbingHashST<Key, Value> {
    private int n;
    private int m = 16;

    private Key[] keys;
    private Value[] values;


    public LinearProbingHashST() {
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
    }

    public LinearProbingHashST(int m) {
        this.m = m;
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
    }

    private int hash(Key key) {
        return (key.hashCode() & Integer.MAX_VALUE) % m;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        //要保证m 是 n的四倍
        if (this.n >= m / 2) {
            resize(2 * m);
        }
        int i = hash(key);
        for (; keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        this.n++;
    }

    public void delete(Key key) {
        //先拿到等于key的i并将对应数组设为Null
        int i = hash(key);
        for (; !key.equals(key); i = (i + 1) % m) {
        }
        keys[i] = null;
        values[i] = null;

        //把后面的移动,填补上面操作导致的Null
        i = (i + 1) % m;
        while (keys[i] != null) {
            Key keyToBeMove = keys[i];
            Value valToBeMove = values[i];

            keys[i] = null;
            values[i] = null;
            this.n--;

            put(keyToBeMove, valToBeMove);
            i = (i + 1) % m;
        }
        this.n--;
        if (n > 0 && n == m / 8) {
            resize(m / 2);
        }
    }

    /**
     * 这个方法太贱了
     *
     * @param cap
     */
    private void resize(int cap) {
        LinearProbingHashST<Key, Value> tempHashST = new LinearProbingHashST<>(cap);
        for (int i = 0; i < this.m; i++) {
            if (keys[i] != null) {
                tempHashST.put(keys[i], values[i]);
            }
        }
        this.keys = tempHashST.keys;
        this.values = tempHashST.values;
        this.m = tempHashST.m;
    }

    public Iterable<Key> keys() {
        MyQueue<Key> queue = new MyQueue<>();
        for (Key key : this.keys) {
            if (key != null) {
                queue.enqueue(key);
            }
        }
        return queue;
    }

    /**
     * e 3.4.20
     * 一次命中的查找成本
     * <p>
     * （待查找的数字肯定在散列表中才会查找成功）
     *
     * @return
     */
    public Double seekSuccessfulAvgCost() {
        int totalTimes = 0;
        Iterator<Key> iterator = keys().iterator();
        while (iterator.hasNext()) {
            Key current = iterator.next();
            int j = 0;
            for (int i = hash(current); keys[i] != null; i = (i + 1) % m, j++) {
                if (keys[i].equals(current)) {
                    totalTimes++;
                    break;
                }
            }
            j++;
            totalTimes += j;
        }

        double totalTImesDouble = totalTimes;
        double totalEleNum = this.n;

        return totalTimes / totalEleNum;
    }

    /**
     * e 3 .4 .21
     * 一次未命中的查找成本
     * <p>
     * （待查找的数字肯定不在散列表中）
     *
     * @return
     */
    public Double seekUnSuccessfulAvgCost() {
        int totalTimes = 0;
        Iterator<Key> iterator = keys().iterator();
        while (iterator.hasNext()) {
            Key current = iterator.next();
            int j = 0;
            int i = hash(current);
            while (keys[i] != null) {
                i = (i + 1) % m;
                j++;
            }
            j++;

            totalTimes += j;
        }
        double totalTImesDouble = totalTimes;
        double totalAddressNum = this.n;//因为是随机算法的hash函数;totalAddressNum是地址的个数

        return totalTImesDouble / totalAddressNum;

    }

}

class AppLinearProbing {
    public static void main(String[] args) {
        LinearProbingHashST<String, Integer> hashST = new LinearProbingHashST<String, Integer>();
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

        Double d1 = hashST.seekUnSuccessfulAvgCost();
        Double d2 = hashST.seekSuccessfulAvgCost();

        System.out.println(d1);
        System.out.println(d2);
    }
}
