package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

import java.util.Stack;

public class _07Parlindrome {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(15);
        node.next.next.next.next.next = new Node(17);
        node.next.next.next.next.next.next = new Node(9);
        node.next.next.next.next.next.next.next = new Node(13);
        node.next.next.next.next.next.next.next.next = new Node(22);
        node.next.next.next.next.next.next.next.next.next = new Node(31);
        node.next.next.next.next.next.next.next.next.next.next = new Node(32);
        _07Parlindrome ispal = new _07Parlindrome();
        boolean ispali = ispal.ispali(node);
        System.out.println(ispali);
    }

    private boolean ispali(Node head) {
       return false;
    }


}
