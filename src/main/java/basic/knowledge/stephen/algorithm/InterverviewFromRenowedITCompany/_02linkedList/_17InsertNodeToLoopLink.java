package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

public class _17InsertNodeToLoopLink {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(6);
        node.next.next.next.next = new Node(9);
        node.next.next.next.next.next = new Node(16);
        node.next.next.next.next.next.next = new Node(17);
        node.next.next.next.next.next.next.next = new Node(28);
        node.next.next.next.next.next.next.next.next = node;


        Node res = insert(node, 7);
        System.out.println();
    }

    private static Node insert(Node head, int num) {
        Node node = new Node(num);
        if(head == null){
            node.next = node;
            return node;
        }
        Node curPre = head;
        Node cur = head.next;
        while (cur != head) {
            if (curPre.value <= num && cur.value >= num) {
                break;
            }
            curPre = cur;
            cur = cur.next;
        }
        curPre.next = node;
        node.next = cur;
        return head.value < num ? head : node;
    }


    static class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
        }
    }
}
