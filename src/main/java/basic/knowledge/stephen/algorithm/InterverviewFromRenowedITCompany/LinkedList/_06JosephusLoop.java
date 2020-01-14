package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany.LinkedList;

public class _06JosephusLoop {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(15);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(10);
        node.next.next.next.next.next.next.next.next = new Node(112);
        node.next.next.next.next.next.next.next.next.next = new Node(-2);
        node.next.next.next.next.next.next.next.next.next.next = node;
        _06JosephusLoop josephusLoop = new _06JosephusLoop();
        Node exist = josephusLoop.josephus(node, 2);
        System.out.println();

    }

    /**
     * head == last时  就只有一个节点了 over
     *
     * @param head
     * @param m
     * @return
     */
    public Node josephus(Node head, int m) {
        if (head == null || m < 1) {
            return head;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (last != head) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
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
