package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

import java.util.HashMap;

//哈希表加setAll功能
//put get containsKey setAll
public class _04SetALL {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(4, 6);
        map.put(4, 8);

        map.setAll(7);
        map.put(4, 8);
        System.out.println(map.get(4));
        System.out.println(map.get(1));
    }
}

/**
 * 一定要保证time为成员变量
 *
 * @param <K>
 * @param <V>
 */
class MyHashMap<K, V> {
    private HashMap<K, MyValue<V>> baseMap;
    private long time;
    private MyValue<V> setAll;

    public MyHashMap() {
        this.baseMap = new HashMap<K, MyValue<V>>();
        this.time = 0;
        this.setAll = new MyValue<V>(null, -1);
    }

    public boolean containsKey(K key) {
        return this.baseMap.containsKey(key);
    }

    public void put(K key, V value) {
        this.baseMap.put(key, new MyValue<>(value, this.time++));
    }

    public void setAll(V value) {
        this.setAll = new MyValue<>(value, this.time++);
    }

    public V get(K key) {
        if (containsKey(key)) {
            if (this.baseMap.get(key).time > this.setAll.time) {
                return this.baseMap.get(key).getValue();
            } else {
                return this.setAll.getValue();
            }
        }
        return null;
    }


    /**
     * 让 value 和 某个time 匹配
     *
     * @param <V>
     */
    static class MyValue<V> {
        private V value;
        private long time;

        public MyValue(V value, long time) {
            this.value = value;
            this.time = time;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }
    }


}

