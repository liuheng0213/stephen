package basic.knowledge.stephen.algorithm_4_Edition.ch3._02Symbol_table_tree;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;

/**
 * void put(Key key, Value val) put key-value pair into the table
 * (remove key from table if value is null)
 * <p>
 * Value get(Key key) value paired with key
 * (null if key is absent)
 * <p>
 * void delete(Key key) remove key (and its value) from table
 * <p>
 * boolean contains(Key key) is there a value paired with key?
 * <p>
 * boolean isEmpty() is the table empty?
 * <p>
 * int size() number of key-value pairs
 * <p>
 * Key min() smallest key
 * <p>
 * Key max() largest key
 * <p>
 * Key floor(Key key) largest key less than or equal to key
 * <p>
 * Key ceiling(Key key) smallest key greater than or equal to key
 * <p>
 * int rank(Key key) number of keys less than key
 * <p>
 * Key select(int k) key of rank k
 * <p>
 * void deleteMin() delete smallest key
 * <p>
 * void deleteMax() delete largest key
 * <p>
 * int size(Key lo, Key hi) number of keys in [lo..hi]
 * <p>
 * Iterable<Key> keys(Key lo, Key hi) keys in [lo..hi], in sorted order
 * <p>
 * Iterable<Key> keys() all keys in the table, in sorted order
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST_Tree<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    private Node root;

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp > 0) {
            return get(node.right, key);
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return node.val;
        }
    }

    public void put(Key key, Value val) {
        root = put(key, val, root);
    }

    private Node put(Key key, Value val, Node node) {
        if (node == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(node.key);

        if (cmp > 0) {
            node.right = put(key, val, node.right);
        } else if (cmp < 0) {
            node.left = put(key, val, node.left);
        } else {
            node.val = val;
        }

        node.n = size(node.right) + size(node.left) + 1;
        return node;

    }

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.n;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }

        return min(node.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }

        return max(node.right);
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    /**
     * 方法含义:
     * 从node的子树开始找  找到合适得node
     * @param node
     * @param key
     * @return
     */
    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return floor(node.left, key);
        } else {//去右子树找
            Node x = floor(node.right, key);
            if (x == null) { //找不到
                return node;
            } else {//找得到
                return x;
            }
        }
    }


    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return ceiling(node.right, key);
        } else {//去左子树找
            Node x = ceiling(node.left, key);
            if (x == null) { //找不到
                return node;
            } else {//找得到
                return x;
            }
        }
    }

    public Key select(int k) {
        Node select = select(root, k);
        if(select == null){
            return null;
        }
        return select.key;
    }

    /**
     * 方法含义:
     * node下的子树找第k个元素key
     * @param node
     * @param k
     * @return
     */
    private Node select(Node node, int k) {
        if (node == null) {
            return null;
        }

        int t = size(node.left);

        if (k < t) {
            return select(node.left, k);
        }else if (k >t){
            return select(node.right,k - t -1 );
        }else{
            return node;
        }
    }

    public int rank(Key key){
        return rank(root,key);
    }

    /**
     * 方法含义:
     * 从node的子树查找, 比key小的键的个数
     * @param node
     * @param key
     * @return
     */
    private int rank(Node node, Key key) {
        if(node == null){
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if(cmp > 0){
            return 1 + size(node.left) +rank(node.right,key);
        }else if(cmp < 0){
            return rank(node.left,key);
        }else{
            return size(node.left);
        }
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    /**
     * 方法含义:
     * 从节点node开始 删除node下的最小key值所在的节点,并返回删除最小节点之后的node
     * 因为删除的最小节点时其父节点都会受到影响
     * @param node
     * @return
     */
    private Node deleteMin(Node node) {
        if(node.left == null){
            return node.right;  //删除自己 返回右子树第一个,不用担心父节点和右子节点的新联系, 递归时已经有联系了
        }
        //删除最小 只对左子树和n有影响, 而且每一层的左子树和n都有影响
        node.left = deleteMin(node.left);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMax(){
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if(node.right == null){
            return node.left;
        }

        node.right = deleteMax(node.right);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key){
        root = delete(root,key);
    }

    /**
     * 方法含义:在node以及其子树下删除键为key的节点
     * @param node
     * @param key
     * @return
     */
    private Node delete(Node node, Key key) {
        if(node == null){
            return null;
        }

        int cmp = key.compareTo(node.key);
        if(cmp < 0 ){  //key 属于node左子节点, 影响左子节点
            node.left = delete(node.left,key );
        }else if(cmp > 0){ //key 属于node右子节点, 影响右子节点
            node.right = delete(node.right,key );
        }else{  // 恰好是node本身
            if(node.right == null){
                return node.left;
            }

            if(node.left == null){
                return node.right;
            }
            Node x = min(node.right);
            x.left = node.left;
            x.right = deleteMin(node.right);
            node = x;
        }
        //调整n
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }


    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key min, Key max) {
        MyQueue<Key> queue = new MyQueue<>();
        keys(min,max,root,queue);
        return queue;
    }

    private void keys(Key lo, Key hi, Node node, MyQueue<Key> queue) {
        int cmpLo = lo.compareTo(node.key);
        int cmpHi = hi.compareTo(node.key);
        if(cmpLo < 0){
            keys(lo,hi ,node.left, queue);
        }
        if(cmpLo <= 0 && cmpHi >=0){
            queue.enqueue(node.key);
        }
        if(cmpHi > 0){
            keys(lo,hi ,node.right, queue);
        }
    }



}
