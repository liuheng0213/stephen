package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany.LinkedList;

import java.util.LinkedList;

/**
 * 有序链表 打印公共部分
 * 双指针
 */
public class _01PrintCommonPart {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(6);
        node1.next.next.next.next = new Node(9);
        node1.next.next.next.next.next = new Node(11);


        Node node2 = new Node(3);
        node2.next = new Node(4);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(6);
        node2.next.next.next.next = new Node(9);
        node2.next.next.next.next.next = new Node(10);


        printCommonPart(node1, node2);
    }

    private static void printCommonPart(Node head1, Node head2) {
        System.out.println("Common part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println("Common part  is ====> " + head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println("print end");
    }
}

class Node {
    int value;
    Node next;

    Node(int data) {
        this.value = data;
    }
}
