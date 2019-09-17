package basic.knowledge.stephen.algorithm_4_Edition.ch3._03Symbol_table_bTree;

public class BinarySearchST_BalanceTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

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

    private void revertFlipColor(Node h) {
        h.color = BLACK;
        h.right.color = RED;
        h.left.color = RED;
    }

    private Node balance(Node node) {
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
            return new Node(key, value, 0, RED);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return put(node.left, key, value);
        } else if (cmp > 0) {
            return put(node.right, key, value);
        } else {
            node.val = value;
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
        if (node.right == null) {
            return node.left;
        }
        if (!isRed(node.right) && !isRed(node.right.left)) {
            node = adjustMax(node);
        }
        node.right = deleteMax(node.right);
        return balance(node);

    }

    private Node adjustMax(Node node) {
        revertFlipColor(node);
        node = rotateRight(node);
        flipColor(node);//这里一定要有, 因为balance的if 判断不符合左3-节点, 右2-节点的情况而不调用flipColor
        return node;
    }


    private Node adjustMin(Node node) {
        revertFlipColor(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            //这里可以不需要flipColor, 因为balance也会执行,单最好也强制该方法
            flipColor(node);
        }
        return node;
    }

    
}


