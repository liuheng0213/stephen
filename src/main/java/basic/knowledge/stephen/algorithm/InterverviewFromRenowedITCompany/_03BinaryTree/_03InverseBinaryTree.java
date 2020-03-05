package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03BinaryTree;

public class _03InverseBinaryTree {
    public static void main(String[] args) {
        _03InverseBinaryTree inverseBinaryTree = new _03InverseBinaryTree();
        Node head = new Node(4);
        head.left = new Node(2);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        //head.left.left.right.right = new Node(7);

        head.right = new Node(7);
        head.right.left = new Node(6);
        head.right.right = new Node(9);

        Node  res= inverseBinaryTree.inverseBin(head);
    }

    /**
     * cur下的子节点实现反转 并返回cur本身
     * @param cur
     * @return
     */
    private Node inverseBin(Node cur) {
        if(cur.right == null && cur.left == null ){
            return cur;
        }
        Node left = inverseBin(cur.left);
        Node right = inverseBin(cur.right);
        //互换left right
        cur.right = left;
        cur.left = right;
        return cur;
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
