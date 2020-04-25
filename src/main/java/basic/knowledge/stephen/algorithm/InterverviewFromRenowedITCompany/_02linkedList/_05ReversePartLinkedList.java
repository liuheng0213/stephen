package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

/**
 * 反转部分单向链表
 */
public class _05ReversePartLinkedList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(6);
        node1.next.next.next.next = new Node(9);
        node1.next.next.next.next.next = new Node(11);
        node1.next.next.next.next.next.next = new Node(15);
        node1.next.next.next.next.next.next.next = new Node(19);
        node1.next.next.next.next.next.next.next.next = new Node(21);

        Node first = reversePartList(node1, 3, 7);
        System.out.println(first.value);
    }

    private static Node reversePartList(Node head, int from, int to) {
        int length = 0;
        Node node1 = head;
        Node fpre = null;// from前的节点
        Node tpos = null;//to 后的节点
        //len 求出来 fpre tpos 也求出来
        while (node1 != null) {
            length++;
            fpre = length == from - 1 ? node1 : fpre;
            tpos = length == to + 1 ? node1 : tpos;
            node1 = node1.next;
        }
        // now cur is the last one
        if (from > to || from < 1 || to > length) {
            return head;
        }
        node1 = fpre == null ? head : fpre.next;
        Node node2 = node1.next;
        node1.next = tpos;
        Node next = null;
        while (node2 != tpos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if (fpre != null) {
            fpre.next = node1;
            return head;
        }
        return node1;
    }


    static class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
        }
    }
}
