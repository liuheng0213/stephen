package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02LinkedList;

import java.util.Stack;

public class _14DelNodeWithDesignatedValue {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next = new Node(1);
        node.next.next.next.next.next.next.next.next = new Node(1);

        Node res = removeValue(node, 1);
        System.out.println(res.value);
    }

    private static Node removeValue(Node head, int num) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }

        //initial head == null
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }

        return head;
    }

    static class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
        }
    }
}
