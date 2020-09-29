package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._02linkedList;

public class _16SelectionSort {
    public static void main(String[] args) {
        Node node = new Node(0);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(9);
       /* node.next.next.next.next.next = new Node(60);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(-8);*/

        _16SelectionSort selectionSort = new _16SelectionSort();
        Node res = selectionSort.selectionSort(node);
        System.out.println(res.value);
    }

    /**
     * cur 未 排序的首节点
     * smallPre 已经排序的最后一个节点
     *
     * @param head
     * @return
     */
    private Node selectionSort(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node small = null;
        Node lastSmall = null;
        Node smallPre = null;
        Node newHead = null;
        while (cur != null) {
            small = cur;
            smallPre = getSmallestPre(cur, small);
            small = smallPre == null ? cur : smallPre.next;


            if (lastSmall == null) {
                lastSmall = small;
                newHead = lastSmall;
            } else {
                lastSmall.next = small;
                lastSmall = lastSmall.next;
            }

            //删掉original 的small
            if (smallPre != null) {
                smallPre.next = small.next;
            }

            //如果small 不是cur自己 千万不要后移
            if(small == cur){
                cur = cur.next;
            }
        }
        return newHead;
    }

    /**
     * 从cur 往后找到最小fgvb  vgny757n的 并且返回这个最小值
     *
     * @param head
     * @return
     */
    private Node getSmallestPre(Node head, Node small) {
        Node smallPre = null;
        Node pre = null;
        while (head != null) {
            if (head.value < small.value) {
                small = head;
                smallPre = pre;
            }
            pre = head;
            head = head.next;
        }
        return smallPre;
    }


}
