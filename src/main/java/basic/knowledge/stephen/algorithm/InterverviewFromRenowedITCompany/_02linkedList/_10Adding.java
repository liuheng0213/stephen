package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

import java.util.Stack;
//两个单链表生成相加链表
public class
_10Adding {
    public static void main(String[] args) {
        _10Adding adding = new _10Adding();
        Node node1 = new Node(9);
        node1.next = new Node(2);
        node1.next.next = new Node(7);


        Node node2 = new Node(6);
        node2.next = new Node(3);

        Node head = adding.addList(node1, node2);
        System.out.println();
    }

    private Node addList(Node head1, Node head2) {
        int n1 = 0;
        int n2 = 0;
        int ca = 0;
        int n = 0;
        Node cur = null;
        Node next = null;
        Stack<Node> stack1 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        Stack<Node> stack2 = new Stack<>();
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop().value;
            n2 = stack2.isEmpty() ? 0 : stack2.pop().value;

            n = n1 + n2 + ca;
            cur = new Node(n % 10);
            cur.next = next;
            next = cur;
            ca = n / 10;
        }


        if (ca == 1) {
            cur = new Node(1);
            cur.next = next;
        }

        return cur;
    }


}
