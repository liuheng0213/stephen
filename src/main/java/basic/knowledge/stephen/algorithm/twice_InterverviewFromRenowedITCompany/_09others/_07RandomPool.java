package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._09others;

import java.util.HashMap;

//设计randompool 结构
public class _07RandomPool {
    public static void main(String[] args) {
        Pool<Integer> pool = new Pool<>();
    }
}

/**
 * 切记 index 和 size 不相等
 *
 * @param <K>
 */
class Pool<K> {
    private HashMap<K, Integer> keyIndexMap;
    private HashMap<Integer, K> indexKeyMap;
    private int size;


    public Pool() {
        this.keyIndexMap = new HashMap<>();
        this.indexKeyMap = new HashMap<>();
        this.size = 0;
    }

    public void insert(K key) {
        if (!this.keyIndexMap.containsKey(key)) {
            this.keyIndexMap.put(key, this.size);//index = actual size - 1
            this.indexKeyMap.put(this.size++, key);
        }
    }

    /**
     * 原则:
     * delkey 一定要删  delindex不能删
     * lastkey 一定不要删  lastindex一定要删
     * @param key
     */
    public void delete(K key) {
        if (this.keyIndexMap.containsKey(key)) {
            int deleteIndex = this.keyIndexMap.get(key);
            int lastIndex = --this.size;
            K lastKey = this.indexKeyMap.get(lastIndex);
            this.indexKeyMap.put(deleteIndex, lastKey);
            this.keyIndexMap.put(lastKey,deleteIndex);
            this.keyIndexMap.remove(key);
            this.indexKeyMap.remove(lastIndex);
        }
    }

    public K getRandom(){
        if(this.size == 0){
            return null;
        }
        int ranIndex = (int) Math.random() * size;
        return this.indexKeyMap.get(ranIndex);

    }
}
