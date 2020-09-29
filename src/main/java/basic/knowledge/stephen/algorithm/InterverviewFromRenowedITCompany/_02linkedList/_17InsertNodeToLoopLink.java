package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

//向有序的环形单链表中插入新节点
public class _17InsertNodeToLoopLink {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(6);
        node.next.next.next.next = new Node(9);
        node.next.next.next.next.next = new Node(16);
        node.next.next.next.next.next.next = new Node(17);
        node.next.next.next.next.next.next.next = new Node(28);
        node.next.next.next.next.next.next.next.next = node;

        _17InsertNodeToLoopLink obj = new _17InsertNodeToLoopLink();
        Node res = obj.insert(node, 30);
        System.out.println(res.value);
    }

    private Node insert(Node head, int num) {
        Node newNode = new Node(num);
        if (head == null) {
            newNode = newNode.next;
            return newNode;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (num <= cur.value && num >= pre.value) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = newNode;
        newNode.next = cur;
        return newNode.value < cur.value ? newNode : cur;
    }


}
