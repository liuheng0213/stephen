package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

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
        if(head == null || head.next == null){
            return head;
        }

        if(head.next.next == null){
            return head.next;
        }

        Node pre = head;
        Node cur = head.next.next;// Node cur = head 则出来时pre恰好再中间位
        while(cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
