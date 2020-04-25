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
        if(head == null || head.next == null){
            return  true;
        }
        Node right = head.next;
        Node cur = head;
        // cur 往前的速度是right的两倍, 从而精确定位right
        while(cur.next != null && cur.next.
                next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while(right != null){
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    static class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
        }
    }
}
