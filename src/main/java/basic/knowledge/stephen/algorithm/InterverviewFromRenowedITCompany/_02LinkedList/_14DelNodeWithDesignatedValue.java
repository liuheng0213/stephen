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

        //Node res = removeValue1(node, 1);
        Node res = removeValue2(node, 1);
        System.out.println(res.value);
    }

    private static Node removeValue2(Node head, int num) {
        while (head != null) {
            if(head.value != num){
                break;
            }
            head = head.next;
        }

        //initial head.value == num
        Node pre = head;
        Node cur = head;
        while(cur != null){
            if(cur.value == num){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    private static Node removeValue1(Node head, int num) {
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
