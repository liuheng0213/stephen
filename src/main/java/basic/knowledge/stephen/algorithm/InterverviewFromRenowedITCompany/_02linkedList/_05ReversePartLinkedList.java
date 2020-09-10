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
        _05ReversePartLinkedList obj = new _05ReversePartLinkedList();
        Node first = obj.reversePartList(node1, 3, 7);
        System.out.println(first.value);
    }

    private Node reversePartList(Node head, int from, int to) {
        return null;
    }


}
