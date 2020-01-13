package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany.LinkedList;

import java.util.Iterator;

public class _04ReverseWholeLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(6);
        node1.next.next.next.next = new Node(9);
        node1.next.next.next.next.next = new Node(11);

        Node first = reverseList(node1);
        System.out.println(first.value);
    }

    private static Node reverseList(Node cur) {//cur 算指针
        Node pre = null;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    static class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
        }
    }
}
