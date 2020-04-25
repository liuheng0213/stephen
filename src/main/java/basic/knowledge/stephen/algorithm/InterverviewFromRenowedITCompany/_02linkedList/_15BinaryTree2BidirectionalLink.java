package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

import java.util.LinkedList;

public class _15BinaryTree2BidirectionalLink {
    public static void main(String[] args) {
        Node node = new Node(6);
        node.left = new Node(4);
        node.right = new Node(7);

        node.left.left = new Node(2);
        node.left.right = new Node(5);
        node.left.left.left = new Node(1);
        node.left.left.right = new Node(3);

        node.right.right = new Node(9);
        node.right.right.left = new Node(8);
        _15BinaryTree2BidirectionalLink binaryTree2BidirectionalLink = new _15BinaryTree2BidirectionalLink();
        Node res = convert1(node);
        System.out.println("=====");

    }

    private static Node convert1(Node head) {
        LinkedList<Node> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        if(queue.isEmpty()){
            return head;
        }
        head = queue.poll();
        Node pre = head;
        pre.left = null;
        Node cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    private static void inOrderToQueue(Node head, LinkedList<Node> queue) {
        if (head == null) {
            return;
        }

        inOrderToQueue(head.left, queue);
        queue.add(head);
        inOrderToQueue(head.right, queue);
    }

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
