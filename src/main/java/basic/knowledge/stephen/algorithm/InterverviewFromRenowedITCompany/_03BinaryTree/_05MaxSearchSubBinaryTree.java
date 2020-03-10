package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03BinaryTree;

/**
 * 二叉树的最大搜索二叉子树
 */
public class _05MaxSearchSubBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(6);
        node.left = new Node(1);
        node.left.left = new Node(0);
        node.left.right = new Node(3);


        node.right = new Node(12);
        node.right.left = new Node(10);
        node.right.right = new Node(13);
        node.right.right.left = new Node(20);
        node.right.right.right = new Node(16);

        node.right.left.left = new Node(4);
        node.right.left.right = new Node(14);

        node.right.left.left.left = new Node(2);
        node.right.left.left.right = new Node(5);
        node.right.left.right.left = new Node(11);
        node.right.left.right.right = new Node(15);
        _05MaxSearchSubBinaryTree maxSearchSubBinaryTree = new _05MaxSearchSubBinaryTree();
        Node res = maxSearchSubBinaryTree.process(node).maxBSHead;
        System.out.println(res);
    }

    /**
     * node (含)
     * 以下的 min max
     * maxBSTHead maxBSTSize
     * @param node
     * @return
     */
    private ReturnType process(Node node) {
        // base case
        if (node == null) {
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        ReturnType leftReturnType = process(node.left);
        ReturnType rightReturnType = process(node.right);
        int min = Math.min(node.value, Math.min(leftReturnType.min, rightReturnType.min));
        int max = Math.max(node.value, Math.max(leftReturnType.max, rightReturnType.max));
        int maxBSTSize = Math.max(leftReturnType.maxBSSize, rightReturnType.maxBSSize);
        Node maxBSTHead = leftReturnType.maxBSSize >= rightReturnType.maxBSSize ?
                leftReturnType.maxBSHead : rightReturnType.maxBSHead;
        //第三种情况:
        if (node.left == leftReturnType.maxBSHead && node.right == rightReturnType.maxBSHead
                && node.value >= leftReturnType.max && node.value <= rightReturnType.min) {
            maxBSTHead = node;
            maxBSTSize = leftReturnType.maxBSSize + rightReturnType.maxBSSize + 1;
        }
        return new ReturnType(maxBSTHead,maxBSTSize,min,max);
    }


    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class ReturnType {
        public Node maxBSHead;
        public int maxBSSize;
        public int min;
        public int max;

        public ReturnType(Node maxBSHead, int maxBSSize, int min, int max) {
            this.maxBSHead = maxBSHead;
            this.maxBSSize = maxBSSize;
            this.min = min;
            this.max = max;
        }
    }
}
