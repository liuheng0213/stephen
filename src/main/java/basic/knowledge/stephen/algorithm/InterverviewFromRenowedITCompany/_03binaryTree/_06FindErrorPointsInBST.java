package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

import java.util.LinkedList;

public class _06FindErrorPointsInBST {
    public Node[] getErrPoints(Node head) {
        if (head == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        Node[] errs = new Node[2];
        Node pre = null;
        while (!queue.isEmpty() || head != null) {
            if (head != null) {
                queue.addLast(head);
                head = head.left;
            } else {
                head = queue.poll();
                if (pre != null && pre.value > head.value) {
                    errs[0] = errs[0] == null ? pre : errs[0];
                    errs[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errs;
    }
}
