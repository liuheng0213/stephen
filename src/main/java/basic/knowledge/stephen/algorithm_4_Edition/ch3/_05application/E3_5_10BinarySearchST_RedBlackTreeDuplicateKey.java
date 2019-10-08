package basic.knowledge.stephen.algorithm_4_Edition.ch3._05application;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.queue.MyQueue;
import basic.knowledge.stephen.algorithm_4_Edition.entity.User;

import java.util.Iterator;

/**
 * 真正用JDK时  可以重写comparable就可以保证重复键存入
 * @param <Key>
 * @param <Value>
 */
public class E3_5_10BinarySearchST_RedBlackTreeDuplicateKey<Key extends Comparable<Key>, Value> {


    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public boolean contains(Key key) {
        int size = get(key).size();
        return size > 0;
    }

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private boolean color;
        private int n;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            this.n = n;
            this.color = color;
        }
    }

    private Node root;

    public boolean isEmpty() {
        return root == null;
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

    public boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
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


    //red left node is rotated to the right
    //make sure sub node has more sub nodes
    private Node rotateLeft(Node node) {
        Node x = node.right;
        //node
        node.right = x.left;
        x.left = node;
        //color
        x.color = node.color;
        node.color = RED;
        //n
        x.n = node.n;// part exchange, so wont impact x.n
        node.n = 1 + size(node.left) + size(node.right);

        return x;
    }

    //red right node is leftet to the right
    //make sure sub node has more sub nodes
    private Node rotateRight(Node node) {
        Node x = node.left;
        //node
        node.left = x.right;
        x.right = node;
        //color
        x.color = node.color;
        node.color = RED;
        //n
        x.n = node.n;// part exchange, so wont impact x.n
        node.n = 1 + size(node.left) + size(node.right);

        return x;
    }

    private void flipColor(Node h) {
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    private void antiFlipColor(Node h) {
        h.color = BLACK;
        h.right.color = RED;
        h.left.color = RED;
    }

    private Node balance(Node node) {
        //平衡deletemax中的旋转操作
        if (isRed(node.right)) {
            node = rotateLeft(node);
        }
        //右红左黑
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        //左红, 左子也红
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColor(node);
        }
        node.n = 1 + size(node.right) + size(node.left);
        return node;
    }


    public MyQueue<Value> get(Key key) {
        MyQueue<Value> queue = new MyQueue<>();
        get(root, key, queue);
        return queue;
    }

    private void get(Node node, Key key, MyQueue<Value> queue) {
        if (node == null) {
            return;
        }
        int cmp = key.compareTo(node.key);
        if (cmp <= 0) {
            get(node.left, key, queue);
        }
        if (cmp == 0) {
            queue.enqueue(node.val);
        }
        if (cmp >= 0) {
            get(node.right, key, queue);
        }
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

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;  // should not ignore;
    }

    /**
     * 从 node 开始在他的子树找到合适的插入位置, 插入后更新受到影响的node节点信息,并返回node
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1, RED);
        }

        int cmp = key.compareTo(node.key);

        if (cmp <= 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        }
        //右红左黑
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        //左红, 左子也红
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColor(node);
        }
        node.n = 1 + size(node.right) + size(node.left);
        return node;
    }

    public void deleteMin() {
        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        //左节点为2-节点, 一共两种情况, 可以画图
        if (!isRed(node.left) && !isRed(node.left.left)) {
            node = adjustMin(node);
        }
        node.left = deleteMin(node.left);
        return balance(node);
    }

    public void deleteMax() {
        root = deleteMax(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    private Node deleteMax(Node node) {
        if (isRed(node.left)) {
            node = rotateRight(node);
        }
        if (node.right == null) {
            return node.left;
        }
        //右节点为2-节点, 一共三种情况, 可以画图
        if (!isRed(node.right) && !isRed(node.right.left)) {
            node = adjustMax(node);
        }
        node.right = deleteMax(node.right);
        return balance(node);

    }

    private Node adjustMax(Node node) {
        antiFlipColor(node);

        if (isRed(node.left.left)) {
            node = rotateRight(node);
        }
        return node;
    }


    private Node adjustMin(Node node) {
        antiFlipColor(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }
        return node;
    }

    public void delete(Key key) {
        //root = delete(root, key);
        while (contains(key)) {
            root = delete(root, key);
        }
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    private Node delete(Node node, Key key) {
        if (key.compareTo(node.key) < 0)
        {
            if (!isRed(node.left) && !isRed(node.left.left))
                node = adjustMin(node);
            node.left = delete(node.left, key);
        }
        else
        {
            if (isRed(node.left))
                node = rotateRight(node);
            if (key.compareTo(node.key) == 0 && (node.right == null))
                return null;
            if (!isRed(node.right) && !isRed(node.right.left))
                node = adjustMax(node);
            if (key.compareTo(node.key) == 0)
            {
                Node x = min(node.right);
                node.key = x.key;
                node.val = x.val;
                node.right = deleteMin(node.right);
            }
            else node.right = delete(node.right, key);
        }
        return balance(node);


        /*if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            try {
                if (!isRed(node.left) && !isRed(node.left.left)) {
                    node = adjustMin(node);
                }
                node.left = delete(node.left, key);
            } catch (Exception e) {
                System.out.println("node" + node);
                System.out.println("node.left" + node.left);
            }
        } else if (cmp > 0) {
            //右节点为2-节点, 一共三种情况, 可以画图
            if (!isRed(node.right) && !isRed(node.right.left)) {
                node = adjustMax(node);
            }
            node.right = delete(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }

            if (node.left == null) {
                return node.right;
            }

            node.val = get(node.right, min(node.right).key);
            node.key = min(node.right).key;
            node.right = deleteMin(node.right);
        }

        return balance(node);*/
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key min, Key max) {
        MyQueue<Key> queue = new MyQueue<>();
        keys(min, max, root, queue);
        return queue;
    }

    private void keys(Key lo, Key hi, Node node, MyQueue<Key> queue) {
        if (node == null) {
            return;
        }
        int cmpLo = lo.compareTo(node.key);
        int cmpHi = hi.compareTo(node.key);
        if (cmpLo < 0) {
            keys(lo, hi, node.left, queue);
        }
        if (cmpLo <= 0 && cmpHi >= 0) {
            queue.enqueue(node.key);
        }
        if (cmpHi > 0) {
            keys(lo, hi, node.right, queue);
        }
    }

    public static void main(String[] args) {
        E3_5_10BinarySearchST_RedBlackTreeDuplicateKey<User, Integer> bst = new E3_5_10BinarySearchST_RedBlackTreeDuplicateKey<>();
        bst.put(new User(1), 1);
        bst.put(new User(12), 12);
        bst.put(new User(21), 21);
        bst.put(new User(15), 15);
        bst.put(new User(19), 19);
        bst.put(new User(14), 14);
        bst.put(new User(14), 14);
        bst.put(new User(14), 14);
        bst.put(new User(16), 16);
        bst.put(new User(19), 19);
        bst.put(new User(21), 21);
        bst.put(new User(22), 22);
        bst.put(new User(21), 21);
        bst.put(new User(32), 32);
        bst.put(new User(111), 111);
        bst.put(new User(18), 18);
        bst.put(new User(25), 25);
        bst.put(new User(31), 31);
        bst.put(new User(21), 21);
        bst.put(new User(31), 31);


        MyQueue<Integer> queues = bst.get(new User(21));

        for (Integer i : queues) {
            System.out.println(i);
        }

        bst.delete(new User(21));
        MyQueue<Integer> queues1 = bst.get(new User(21));
        System.out.println();
        //bst.deleteMax();
        //bst.deleteMin();
       /* bst.delete(new User(21));

        Iterable<User> keys = bst.keys();
        Iterator<User> iterator = keys.iterator();
        while(iterator.hasNext()){
            User next = iterator.next();
            System.out.println(next);
        }*/
    }


}


