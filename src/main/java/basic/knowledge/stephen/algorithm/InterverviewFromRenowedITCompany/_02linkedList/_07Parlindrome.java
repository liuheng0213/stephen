package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

import java.util.Stack;

public class _07Parlindrome {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(15);
        node.next.next.next.next.next = new Node(4);
        node.next.next.next.next.next.next = new Node(3);
        node.next.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next.next = new Node(1);
        _07Parlindrome ispal = new _07Parlindrome();
        boolean ispali = ispal.ispali(node);
        System.out.println(ispali);
    }

    private boolean ispali(Node head) {
        if (head == null) {
            return false;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while(!stack.isEmpty() && head != null){
            if(stack.pop().value != head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }


}
