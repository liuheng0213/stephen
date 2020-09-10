package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

// 删除链表的中间节点, 可用等差数列证明 pre就是中间节点的前一个结点
public class _03DeleteMiddleNodeInLinkedlist {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(6);
        node1.next.next.next.next = new Node(9);
        node1.next.next.next.next.next = new Node(11);
        _03DeleteMiddleNodeInLinkedlist deleteMiddleNodeInLinkedlist = new _03DeleteMiddleNodeInLinkedlist();
        Node node = deleteMiddleNodeInLinkedlist.removeMidNode(node1);
        System.out.println();
    }

    private Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            Node newHead = head.next;
            head = null;
            return newHead;
        }

        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return pre;
    }
}
