package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

public class HeadSample {
    public static Node generateHeadSample() {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(4);
        head.left.left.left = new Node(14);
        head.left.left.right = new Node(6);
        head.left.left.right.right = new Node(7);

        head.right = new Node(3);
        head.right.left = new Node(5);
        head.right.left.right = new Node(15);
        head.right.left.left = new Node(10);
        head.right.left.left.right = new Node(10);
        head.right.left.left.right.left = new Node(10);

        return head;
    }
}
