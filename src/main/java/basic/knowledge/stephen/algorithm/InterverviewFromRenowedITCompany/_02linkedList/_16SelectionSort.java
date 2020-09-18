package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

public class _16SelectionSort {
    public static void main(String[] args) {
        Node node = new Node(5);
        node.next = new Node(4);
        node.next.next = new Node(8);
        node.next.next.next = new Node(1);
        node.next.next.next.next = new Node(3);
       /* node.next.next.next.next.next = new Node(60);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(-8);*/

        _16SelectionSort selectionSort = new _16SelectionSort();
        Node res = selectionSort.selectionSort(node);
        System.out.println(res.value);
    }

    /**
     * 
     * @param head
     * @return
     */
    private Node selectionSort(Node head) {
        Node cur = head;//运行指针  针对未排序链表
        Node small = null;//最小的节点

        Node smaller = null;//最小的节点前一个节点
        while (cur != null) {
            small = getSmallestPre(cur);
            if (smaller != null) {
                smaller.next = small;
            } else {
                head = small;
            }
            cur = cur.value == small.value ? cur.next : cur;
            smaller = small;
        }
        return head;
    }

    /**
     * 从cur 往后找到最小的 并且返回这个最小值
     *
     * @param head
     * @return
     */
    private Node getSmallestPre(Node head) {
        Node cur = head.next;
        Node pre = head;
        Node small = head;
        Node smallPre = null;
        while (cur != null) {
            if (cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        //以下是为了删掉small 以后不能再用了
        if (smallPre != null) {
            smallPre.next = small.next;
        }
        return small;
    }


}
