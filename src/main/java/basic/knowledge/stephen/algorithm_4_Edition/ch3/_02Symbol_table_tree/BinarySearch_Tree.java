package basic.knowledge.stephen.algorithm_4_Edition.ch3._02Symbol_table_tree;

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
public class BinarySearch_Tree<Key extends Comparable<Key>, Value> {

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
        Node node = floor(root, key);// 方法意义: 从root开始找  找到合适得node
        if (node == null) {
            return null;
        }
        return node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return floor(node.left, key);
        }else{//去右子树找
            Node x = floor(node.right,key);
            if(x == null){ //找不到
                return node;
            }else{//找得到
                return x;
            }
        }
    }


    public Key ceiling(Key key){
        Node node = ceiling(root,key);
        if(node == null){
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
        }else{//去左子树找
            Node x = ceiling(node.left,key);
            if(x == null){ //找不到
                return node;
            }else{//找得到
                return x;
            }
        }
    }

}
