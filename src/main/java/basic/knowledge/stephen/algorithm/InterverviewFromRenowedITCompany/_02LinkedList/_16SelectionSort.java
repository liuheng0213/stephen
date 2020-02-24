package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02LinkedList;

public class _16SelectionSort {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(2);
        node.next.next = new Node(13);
        node.next.next.next = new Node(15);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(60);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(-8);

        _16SelectionSort selectionSort = new _16SelectionSort();
        Node res = selectionSort.selectionSort(node);
        System.out.println(res);
    }

    private Node selectionSort(Node head) {
        Node tail = null;//排序部分末尾
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
        Node min = head;
        Node minPre = null;
        while (cur != null) {
            if (cur.value < min.value) {
                minPre = pre;
                min = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        if (minPre != null) {
            minPre.next = min.next;
        }
        return min;
    }

    static class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
        }
    }
}
