package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

//反转链表所有节点
public class _04ReverseWholeLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(6);
        node1.next.next.next.next = new Node(9);
        node1.next.next.next.next.next = new Node(11);
        _04ReverseWholeLinkedList obj = new _04ReverseWholeLinkedList();
        Node first = obj.reverseList(node1);
        System.out.println(first.value);
    }

    private Node reverseList(Node head) {
        if (head == null) {
            return head;
        }

        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

}
