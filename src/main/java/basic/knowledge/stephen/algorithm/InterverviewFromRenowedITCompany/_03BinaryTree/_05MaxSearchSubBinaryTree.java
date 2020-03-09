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

    private ReturnType process(Node node) {
        // base case
        if (node == null) {
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }


        ReturnType leftReturnType = process(node.left);
        ReturnType rightReturnType = process(node.right);
        if (leftReturnType.maxBSHead != node.left || rightReturnType.maxBSHead != node.right) {
            if (leftReturnType.maxBSSize >= rightReturnType.maxBSSize) {
                return leftReturnType;
            } else {
                return rightReturnType;
            }
        } else {
            if (node.value >= leftReturnType.max && node.value <= rightReturnType.min) {
                return new ReturnType(node, leftReturnType.maxBSSize > rightReturnType.maxBSSize ? leftReturnType.maxBSSize : rightReturnType.maxBSSize,
                        leftReturnType.min, rightReturnType.max);
            } else {
                if (leftReturnType.maxBSSize >= rightReturnType.maxBSSize) {
                    return leftReturnType;
                } else {
                    return rightReturnType;
                }
            }
        }
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
