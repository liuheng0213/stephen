package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch3._05application;

import edu.princeton.cs.algs4.LinearProbingHashST;

import java.util.LinkedList;

/**
 * LRU缓存
 * @param <Item>
 */
public class E3_5_26LRUCache<Item> {
    public static void main(String[] args) {
        E3_5_26LRUCache<String> cache = new E3_5_26LRUCache<>();
        cache.access("a");
        cache.access("b");
        cache.access("c");
        cache.access("d");
        cache.access("e");
        cache.access("f");
        cache.access("g");
        cache.access("h");
        cache.access("i");

        cache.access("g");
        cache.access("f");
        cache.access("e");
        cache.access("g");
        cache.access("b");
        System.out.println();
    }

    public E3_5_26LRUCache() {
        linkedList = new LinkedList<>();//jdk的LinkedList是双向链表,且支持索引遍历
        st = new LinearProbingHashST<>();
    }

    private LinkedList<Item> linkedList;
    private LinearProbingHashST<Item, Integer> st;
    private Integer firstPoint;  //头指针
    private Integer lastPoint;   //尾指针

    public void access(Item item) {
        if (isEmpty()) {
            this.firstPoint = 0;
            this.lastPoint = 0;
            linkedList.addFirst(item);
            st.put(item, firstPoint);
            return;
        }

        if (contains(item)) {
            //更新hashST
            for (int i = this.firstPoint; i < st.get(item); i++) {
                Item itemTemp = linkedList.get(i);
                st.put(itemTemp, st.get(itemTemp) + 1);
            }
            linkedList.remove(item);
            linkedList.addFirst(item);
            st.put(item, this.firstPoint);
        } else {
            //更新hashST
            for (int i = this.firstPoint; i <= this.lastPoint; i++) {
                Item itemTemp = linkedList.get(i);
                st.put(itemTemp, st.get(itemTemp) + 1);
            }
            linkedList.addFirst(item);
            st.put(item, this.firstPoint);
            this.lastPoint++;
        }
    }

    /**
     * 访问次数最少的元素是最底部的元素
     * @return
     */
    public Item delete() {
        Item item = linkedList.removeLast();
        st.delete(item);
        return item;
    }

    private boolean isEmpty() {
        return firstPoint == null && lastPoint == null;
    }

    public boolean contains(Item item) {
        return linkedList.contains(item) && st.contains(item);
    }

    public int size() {
        if(isEmpty()){
            return 0;
        }
        return lastPoint - firstPoint + 1;
    }
}
