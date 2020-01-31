package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02LinkedList;

import java.util.Stack;

public class _10adding {
    public static void main(String[] args) {
        _10adding adding = new _10adding();
        Node node1 = new Node(9);
        node1.next = new Node(3);
        node1.next.next = new Node(7);


        Node node2 = new Node(6);
        node2.next = new Node(3);

        Node head = adding.addList(node1, node2);
        System.out.println();
    }

    private Node addList(Node head1, Node head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(head1 != null){
            s1.push(head1.value);
            head1 = head1.next;
        }

        while(head2 != null){
            s2.push(head2.value);
            head2 = head2.next;
        }
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        while(!s1.isEmpty() || !s2.isEmpty()){
            n1 = s1.isEmpty() ? 0 :s1.pop();
            n2 = s2.isEmpty() ? 0: s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node( n % 10);
            node.next = pre;
            ca = n / 10;
        }


        if(ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }

        return node;
    }


    static class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
        }
    }
}
