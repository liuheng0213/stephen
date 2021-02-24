package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._09others;

import java.util.HashMap;

//设计LRU缓存
//凡是用过的(set get)就是最常用的 head 里是最不常用的, 两个最
public class _06LRU {
    public static void main(String[] args) {
        MyCache<String, Integer> myCache = new MyCache<>(5);
        myCache.set("a",1);
        myCache.set("b",2);
        myCache.set("c",3);
        myCache.set("d",4);
        myCache.set("e",4);
        myCache.set("f",4);
    }

}

/**
 * 设计set get方法
 *
 * @param <K>
 * @param <V>
 */
class MyCache<K, V> {
    private HashMap<K, NodeList.Node<V>> keyNodeMap;
    private HashMap<NodeList.Node<V>, K> nodeKeyMap;
    private NodeList<V> nodeList;
    private Integer capacity;


    public MyCache(Integer capacity) {
        if (capacity < 1) {
            throw new RuntimeException("must be more than 0");
        }
        this.keyNodeMap = new HashMap<>();
        this.nodeKeyMap = new HashMap<>();
        this.nodeList = new NodeList<>();
        this.capacity = capacity;
    }

    /**
     * either add or update
     *
     * @param key
     * @param value
     */
    public void set(K key, V value) {
        if (keyNodeMap.containsKey(key)) {
            NodeList.Node<V> node = this.keyNodeMap.get(key);
            node.value = value;
            this.nodeList.moveNodeToTail(node);
        } else {
            NodeList.Node<V> node = new NodeList.Node<V>(value);
            this.keyNodeMap.put(key, node);
            this.nodeKeyMap.put(node, key);
            this.nodeList.addNode(node);
            if (this.keyNodeMap.size() == capacity + 1) {
                this.removeMostUnusedCache();
            }
        }
    }

    private void removeMostUnusedCache() {
        NodeList.Node<V> node = this.nodeList.removeHead();
        K key = this.nodeKeyMap.get(node);
        this.nodeKeyMap.remove(node);
        this.keyNodeMap.remove(key);
    }
}

class NodeList<V> {
    public NodeList() {
        this.head = null;
        this.tail = null;
    }

    static class Node<V> {
        public V value;
        public Node pre;
        public Node next;

        public Node(V value) {
            this.value = value;
        }
    }

    private Node<V> head;
    private Node<V> tail;

    public void addNode(Node<V> newNode) {
        if (newNode == null) {
            return;
        }
        if (this.head == null) {//size == 0
            this.head = newNode;
            this.tail = newNode;
        } else { //size > 0
            this.tail.next = newNode;
            newNode.pre = this.tail;
            this.tail = newNode;
        }
    }

    public void moveNodeToTail(Node<V> node) {
        if (node == null) {
            return;
        }
        if (this.head == node) {
            this.head = node.next;
            this.head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        tail.next = node;
        node.pre = this.tail;
        this.tail = node;
        this.tail.next = null;
    }

    /**
     * removeHead并返回
     * 返回的目的 是i需要删除相对应于cache中的两个map
     *
     * @return
     */
    public Node<V> removeHead() {
        if (this.head == null) {
            return null;
        }
        Node<V> res = this.head;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = res.next;
            res.next = null;
            this.head.pre = null;

        }
        return res;
    }

}
