package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

/**
 * 有序链表 打印公共部分
 * 双指针
 */
public class _01PrintCommonPart {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(6);
        node1.next.next.next.next = new Node(9);
        node1.next.next.next.next.next = new Node(11);


        Node node2 = new Node(3);
        node2.next = new Node(4);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(6);
        node2.next.next.next.next = new Node(9);
        node2.next.next.next.next.next = new Node(10);

        _01PrintCommonPart obj = new _01PrintCommonPart();
        obj.printCommonPart(node1, node2);
    }

    private void printCommonPart(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        while (node1 != null && node2 != null) {
            if (node1.value < node2.value) {
                node1 = node1.next;
            } else if (node1.value > node2.value) {
                node2 = node2.next;
            } else {
                System.out.println(node1.value);
                node1 = node1.next;
                node2 = node2.next;
            }
        }
    }


}

