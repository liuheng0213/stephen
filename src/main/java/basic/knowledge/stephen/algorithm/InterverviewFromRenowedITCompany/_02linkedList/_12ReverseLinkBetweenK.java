package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

import java.util.Stack;

public class _12ReverseLinkBetweenK {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);

        Node res = reverseLinkList(node, 3);
        System.out.println(res);

    }


    public static Node reverseLinkList(Node head, int k) {
        if (k < 2) {
            return head;
        }
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        Stack<Node> stack = new Stack<>();
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            while (stack.size() == k) {
                pre = adjust(stack, pre, next);
                newHead = newHead == head ? cur : newHead;//newHead== head 说明是第一次三个， ！= Head 说明换过了 不要再换了
            }
            cur = next;
        }
        return newHead;
    }

    private static Node adjust(Stack<Node> stack, Node left, Node right) {
        Node cur = stack.pop();
        if (left != null) {
            left.next = cur;
        }
        Node next = null;
        while (!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }


    static class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
        }
    }
}
