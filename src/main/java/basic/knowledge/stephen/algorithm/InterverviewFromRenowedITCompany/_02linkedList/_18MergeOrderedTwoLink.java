package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;


//合并两个有序的列表 合并后保持有序
public class _18MergeOrderedTwoLink {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(4);


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

    private Node merge(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        } else if (head1 != null && head2 == null) {
            return head1;
        } else if (head1 == null && head2 != null) {
            return head2;
        }

        Node cur = head1.value < head2.value ? head1 : head2;
        Node head = cur;
        head1 = cur == head1 ? head1.next : head1;
        head2 = cur == head2 ? head2.next : head2;
        while (head1 != null || head2 != null) {
            if (head1 != null && head2 != null) {
                if (head1.value < head2.value) {
                    cur.next = head1;
                    head1 = head1.next;
                } else {
                    cur.next = head2;
                    head2 = head2.next;
                }

            } else if (head1 != null && head2 == null) {
                cur.next = head1;
                head1 = head1.next;
            }else{
                cur.next = head2;
                head2 = head2.next;
            }

            cur = cur.next;
        }

        return head;
    }


}
