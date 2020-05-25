package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

public class
_08Pivot {
    public static void main(String[] args) {
        _08Pivot pivot = new _08Pivot();
        Node node = new Node(7);
        node.next = new Node(9);
        node.next.next = new Node(1);
        node.next.next.next = new Node(8);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next = new Node(5);
        Node head = pivot.listPartition(node, 5);
        System.out.println();
    }

    private Node listPartition(Node head, int pivot) {
        Node sH = null;
        Node sT = null; //指向前半段的尾部
        Node eH = null;
        Node eT = null; //指向中间段的尾部
        Node bH = null;
        Node bT = null; //指向后半段的尾部
        Node next = null;
        //下面的设计 精巧!!
        while (head != null) {
            next = head.next;
            head.next = null;//very important 虽然没有这一步 也不影响最终结果  因为会覆盖  但是SH ST之间不对
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        //小的和相等的重新链接
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        //所有的重新连接
        if (eT != null) {
            eT.next = bH;
        }

        return sH != null ? sH : (eH != null ? eH : bH);
    }


    static class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
        }
    }
}
