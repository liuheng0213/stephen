package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

import java.util.LinkedList;

public class _06PrintByLayer {
    public static void main(String[] args) {
        Node node = HeadSample.generateHeadSample();
        _06PrintByLayer obj = new _06PrintByLayer();
        obj.printByLayer(node);
    }

    public void printByLayer(Node head) {
        if (head == null) {
            return;
        }
        Node last = head;
        Node nlast = null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(head);
        int level = 1;
        System.out.print("Level: " + (level++) + "-->");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if (head.left != null) {
                queue.addLast(head.left);
                nlast = head.left;
            }

            if (head.right != null) {
                queue.addLast(head.right);
                nlast = head.right;
            }

            if (head == last && !queue.isEmpty()) {
                System.out.print("\nLevel: " + (level++) + "-->");
                last = nlast;
            }
        }
    }
}
