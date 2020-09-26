package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

//环形单链表的约瑟夫环问题
public class _06JosephusLoop {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(5);
        node.next.next.next.next.next.next = node;
        _06JosephusLoop josephusLoop = new _06JosephusLoop();
        Node exist = josephusLoop.josephus(node, 4);
        System.out.println();

    }

    /**
     * head == last时  就只有一个节点了 over
     *
     * @param head
     * @param m
     * @return
     */
    public Node josephus(Node head, int m) {
        if (head == null || head == head.next || m < 1) {
            return null;
        }

        Node last = head;
        while (last.next != head) {
            last = last.next;
        }

        // now cur is head and last is last
        int len = 0;
        while(head.next != head){
            if(++len == m){
                last.next = head.next;
                len = 0;
            }else{
                last = head;
            }
            head = head.next;
        }
        //now cur == cur.next

        return head;
    }

}
