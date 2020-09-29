package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

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
        _18MergeOrderedTwoLink obj = new _18MergeOrderedTwoLink();
        Node res = obj.merge(head1, head2);
        System.out.println(res);
    }

    private  Node merge(Node head1, Node head2) {
        return null;
    }



}
