package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

import java.util.LinkedList;
import java.util.Queue;

public class _15BinaryTree2BidirectionalLink {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(4);
        node.right = new TreeNode(7);

        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(1);
        node.left.left.right = new TreeNode(3);

        node.right.right = new TreeNode(9);
        node.right.right.left = new TreeNode(8);
        _15BinaryTree2BidirectionalLink obj = new _15BinaryTree2BidirectionalLink();
        //DoubleNode res = obj.convert1(node);
        DoubleNode res = obj.convert2(node);
        System.out.println("=====");

    }

    private DoubleNode convert2(TreeNode head) {
        if (head == null) {
            return null;
        }
        return process(head).start;
    }

    private ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(null, null);
        }
        ReturnType leftReturnType = process(head.left);
        ReturnType rightReturnType = process(head.right);
        DoubleNode midDoubleNode = new DoubleNode(head.value);
        if (leftReturnType.end != null) {
            leftReturnType.end.next = midDoubleNode;
        }

        midDoubleNode.pre = leftReturnType.end;
        midDoubleNode.next = rightReturnType.start;

        if (rightReturnType.start != null) {
            rightReturnType.start.pre = midDoubleNode;
        }


        return new ReturnType(leftReturnType.start == null ? midDoubleNode : leftReturnType.start
                , rightReturnType.end == null ? midDoubleNode : rightReturnType.end);
    }


    private DoubleNode convert1(TreeNode head) {
        if (head == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        insertToQueue(queue, head);

        DoubleNode pre = new DoubleNode(queue.poll().value);
        DoubleNode newHead = pre;
        DoubleNode cur = null;

        while (!queue.isEmpty()) {
            cur = new DoubleNode(queue.poll().value);
            pre.next = cur;
            cur.pre = pre;
            pre = cur;
        }


        return newHead;
    }

    private void insertToQueue(Queue<TreeNode> queue, TreeNode head) {
        if (head == null) {
            return;
        }
        insertToQueue(queue, head.left);
        queue.add(head);
        insertToQueue(queue, head.right);
    }

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }
    }

    class ReturnType {
        DoubleNode start;
        DoubleNode end;

        public ReturnType(DoubleNode start, DoubleNode end) {
            this.start = start;
            this.end = end;
        }
    }
}
