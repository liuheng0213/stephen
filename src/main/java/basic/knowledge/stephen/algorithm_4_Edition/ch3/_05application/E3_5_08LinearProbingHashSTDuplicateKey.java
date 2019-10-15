package basic.knowledge.stephen.algorithm_4_Edition.ch3._05application;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;

import java.util.Iterator;

public class E3_5_08LinearProbingHashSTDuplicateKey<Key, Value> {
    public static void main(String[] args) {
        E3_5_08LinearProbingHashSTDuplicateKey<Integer, Integer> hashST = new E3_5_08LinearProbingHashSTDuplicateKey();
        hashST.put(1, 1);
        hashST.put(2, 2);
        hashST.put(3, 3);
        hashST.put(4, 4);
        hashST.put(1, 2);
        hashST.put(1, 3);
        hashST.put(1, 4);
        hashST.put(12, 12);
        hashST.put(12, 12);
        hashST.put(13, 13);
        hashST.put(14, 14);
        hashST.put(1, 5);
        hashST.put(1, 6);
        hashST.put(21, 21);
        hashST.put(22, 22);
        hashST.put(33, 33);
        hashST.put(1, 7);


        Iterable<Integer> keys = hashST.keys();
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===============");
        System.out.println(hashST.size());
        System.out.println("========================");

        MyQueue<Integer> integersQueue = hashST.get(12);
        Iterator<Integer> iterator1 = integersQueue.iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            System.out.println(next);
        }


        hashST.delete(12);

        MyQueue<Integer> integersQueue1 = hashST.get(12);
        if(integersQueue1.isEmpty()){
            System.out.println("queue is empty!!!");
        }
        Iterator<Integer> iterator2 = integersQueue1.iterator();
        while (iterator2.hasNext()) {
            Integer next = iterator2.next();
            System.out.println(next);
        }
    }

    private int n;
    private int m = 16;

    private Key[] keys;
    private Value[] values;


    public E3_5_08LinearProbingHashSTDuplicateKey() {
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
    }

    public E3_5_08LinearProbingHashSTDuplicateKey(int m) {
        this.m = m;
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
    }

    public int size() {
        return this.n;
    }

    private int hash(Key key) {
        return (key.hashCode() & Integer.MAX_VALUE) % m;
    }

    public MyQueue<Value> get(Key key) {
        MyQueue<Value> queue = new MyQueue<>();
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                queue.enqueue(values[i]);
            }
        }
        return queue;
    }


    public void put(Key key, Value value) {
        //要保证m 是 n的四倍
        if (this.n >= m / 2) {
            resize(2 * m);
        }
        int i = hash(key);
        for (; keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                continue;
            }
        }
        keys[i] = key;
        values[i] = value;
        this.n++;
    }

    private void delete(Key key) {
        //先拿到等于key的i并将对应数组设为Null
        int i = hash(key);
        for (; keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                keys[i] = null;
                values[i] = null;
                this.n--;
            }
        }


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
        E3_5_08LinearProbingHashSTDuplicateKey<Key, Value> tempHashST = new E3_5_08LinearProbingHashSTDuplicateKey<>(cap);
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

    public boolean contains(Key key) {
        return get(key).size() > 0;
    }
}
