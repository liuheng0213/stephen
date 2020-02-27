package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02LinkedList;

public class _18MergeOrderedTwoLink {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(7);
        head1.next.next.next.next = new Node(9);
        head1.next.next.next.next.next = new Node(16);
        head1.next.next.next.next.next.next = new Node(27);
        head1.next.next.next.next.next.next.next = new Node(28);


        Node head2 = new Node(0);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = new Node(10);
        head2.next.next.next.next.next = new Node(15);
        head2.next.next.next.next.next.next = new Node(17);
        head2.next.next.next.next.next.next.next = new Node(38);
        head2.next.next.next.next.next.next.next.next = new Node(48);

        Node res = merge(head1, head2);
        System.out.println(res);
    }

    private static Node merge(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        Node head = head1.value > head2.value ? head2 : head1;
        Node cur = head;
        Node cur1 = head1.value > head2.value ? head1 : head1.next;
        Node cur2 = head1.value > head2.value ? head2.next : head1;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null && cur2 != null) {
                if (cur1.value > cur2.value) {
                    cur.next = cur2;
                    cur2 = cur2.next;
                } else {
                    cur.next = cur1;
                    cur1 = cur1.next;
                }
            } else if (cur1 == null) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else {
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur = cur.next;
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
