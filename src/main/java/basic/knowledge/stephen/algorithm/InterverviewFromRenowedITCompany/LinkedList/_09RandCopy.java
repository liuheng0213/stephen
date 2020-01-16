package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class _09RandCopy {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.rand = node.next.next;
        node.next.rand = null;
        node.next.next.rand = node;


        _09RandCopy randCopy = new _09RandCopy();
        Node first = randCopy.copyListWithRand(node);
        System.out.println();

    }

    private Node copyListWithRand(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }


    static class Node {
        int value;
        Node next;
        Node rand;

        Node(int data) {
            this.value = data;
        }
    }
}
