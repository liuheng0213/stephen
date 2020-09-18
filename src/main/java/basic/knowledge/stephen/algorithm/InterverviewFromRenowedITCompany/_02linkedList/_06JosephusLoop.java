package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

//环形单链表的约瑟夫环问题
public class _06JosephusLoop {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(15);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(10);
        node.next.next.next.next.next.next.next.next = new Node(112);
        node.next.next.next.next.next.next.next.next.next = new Node(-2);
        node.next.next.next.next.next.next.next.next.next.next = node;
        _06JosephusLoop josephusLoop = new _06JosephusLoop();
        Node exist = josephusLoop.josephus(node, 2);
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
        return null;
    }

}
