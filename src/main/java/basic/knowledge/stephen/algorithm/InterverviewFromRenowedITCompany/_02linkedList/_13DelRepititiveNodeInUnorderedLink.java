package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

import java.util.HashSet;

public class _13DelRepititiveNodeInUnorderedLink {
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

        removeRep(node);
        System.out.println(1);
    }

    private static void removeRep(Node head) {
        if(head == null){
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value); //第一个节点不删
        while(cur != null){
            if(set.contains(cur.value)){
                pre.next = cur.next;
            }else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }

    }


    static class Node {
        int value;
        Node next;
        
        Node(int data) {
            this.value = data;
        }
    }
}
