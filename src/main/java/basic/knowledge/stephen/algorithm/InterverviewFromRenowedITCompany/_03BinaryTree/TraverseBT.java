package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03BinaryTree;

/**
 * 前序中序后序遍历一个二叉树
 */
public class TraverseBT {
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

        TraverseBT traverse = new TraverseBT();
        //traverse.preArr(node, 1);
        //traverse.midArr(node, 1);
        traverse.postArr(node, 1);
    }

    private void postArr(Node head, int level) {
        if (head == null) {
            return;
        }
        preArr(head.left, level + 1);
        preArr(head.right, level + 1);
        System.out.println("head data -->" + head.value + ", level -->" + level);
    }

    private void midArr(Node head, int level) {
        if (head == null) {
            return;
        }
        preArr(head.left, level + 1);
        System.out.println("head data -->" + head.value + ", level -->" + level);
        preArr(head.right, level + 1);
    }

    private void preArr(Node head, int level) {
        if (head == null) {
            return;
        }
        System.out.println("head data -->" + head.value + ", level -->" + level);
        preArr(head.left, level + 1);
        preArr(head.right, level + 1);
    }


    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
